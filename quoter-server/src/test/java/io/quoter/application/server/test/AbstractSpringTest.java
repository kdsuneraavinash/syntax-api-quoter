/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.quoter.application.server.test;

import io.quoter.application.server.QuoterSpringBoot;
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

import java.security.AccessController;
import java.security.PrivilegedAction;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Base Spring Test class.
 */
@SpringBootTest(classes = QuoterSpringBoot.class)
public abstract class AbstractSpringTest extends AbstractTestNGSpringContextTests {
    private static final String TEMPLATE_PACKAGE_NAME = "templatepkg.TemplateCodeImpl";

    private static class SegmentClassLoader extends ClassLoader {
    }

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
            TemplateCode templateCode = AccessController.doPrivileged(
                    (PrivilegedAction<TemplateCode>) () -> {
                        try {
                            ClassLoader classLoader = new SegmentClassLoader();
                            CachedCompiler compiler = new CachedCompiler(null, null);
                            Class templateCodeImpl = compiler.loadFromJava(classLoader, TEMPLATE_PACKAGE_NAME, javaCode);
                            return (TemplateCode) templateCodeImpl.getDeclaredConstructor().newInstance();
                        } catch (ReflectiveOperationException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );

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

        assert mockMvc != null;
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
