package io.ballerinalang.quoter.test.spring;

import io.ballerinalang.quoter.QuoterSpringBoot;
import io.ballerinalang.quoter.test.TemplateCode;
import io.ballerinalang.quoter.utils.FileReaderUtils;
import net.openhft.compiler.CachedCompiler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Base Spring Test class.
 */
@SpringBootTest(classes = QuoterSpringBoot.class)
public abstract class AbstractSpringTest extends AbstractTestNGSpringContextTests {
    private static final String TEMPLATE_PACKAGE_NAME = "templatepkg.TemplateCodeImpl";

    @Autowired
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    /**
     * Wire the web application context.
     */
    @BeforeClass
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * Evaluate a Java code segment.
     *
     * @param javaCode Input java source code
     * @return Output from the generated code.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected String runAndGetOutput(String javaCode) {
        try {
            ClassLoader classLoader = new ClassLoader() {
            };
            CachedCompiler compiler = new CachedCompiler(null, null);
            Class templateCodeImpl = compiler.loadFromJava(classLoader, TEMPLATE_PACKAGE_NAME, javaCode);
            TemplateCode templateCode = (TemplateCode) templateCodeImpl.getDeclaredConstructor().newInstance();

            return templateCode.getNode().syntaxTree().toSourceCode();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Test whether the bal file content and the evaluated java code
     * from sending the post request are the same.
     * Uses the given formatter and template to test the code.
     *
     * @param balFile       Ballerina source code file
     * @param formatterName Formatter name to use
     * @param template      Test Template file name to use
     */
    protected void testAssertionFiles(String balFile, String formatterName, String template) throws Exception {
        String templateCode = FileReaderUtils.readFileAsResource(template);
        String balCode = FileReaderUtils.readFileAsResource(balFile);

        RequestBuilder postReq = post("/generate?template=false&format=" + formatterName).content(balCode);

        String generatedCode = mockMvc.perform(postReq)
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();

        String javaCode = String.format(templateCode, generatedCode);
        String javaOutput = runAndGetOutput(javaCode);
        Assert.assertEquals(javaOutput, balCode);
    }

    /**
     * Test whether the bal file content and the evaluated java code
     * from sending the post request are the same.
     * Tests the all formatters.
     *
     * @param balFile Ballerina source code file
     */
    protected void testAssertionFiles(String balFile) throws Exception {
        testAssertionFiles(balFile, "none", "template-default.java");
        testAssertionFiles(balFile, "default", "template-default.java");
        testAssertionFiles(balFile, "variable", "template-variable.java");
    }
}
