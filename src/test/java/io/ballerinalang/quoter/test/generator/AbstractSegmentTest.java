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
package io.ballerinalang.quoter.test.generator;

import io.ballerina.compiler.syntax.tree.Node;
import io.ballerina.compiler.syntax.tree.SyntaxTree;
import io.ballerina.tools.text.TextDocument;
import io.ballerina.tools.text.TextDocuments;
import io.ballerinalang.quoter.config.QuoterConfig;
import io.ballerinalang.quoter.formatter.SegmentFormatter;
import io.ballerinalang.quoter.segment.Segment;
import io.ballerinalang.quoter.segment.factories.NodeSegmentFactory;
import io.ballerinalang.quoter.test.TemplateCode;
import io.ballerinalang.quoter.test.TestQuoterConfig;
import io.ballerinalang.quoter.utils.FileReaderUtils;
import net.openhft.compiler.CachedCompiler;
import org.testng.Assert;

/**
 * Test Base class with several helper functions.
 */
public abstract class AbstractSegmentTest {
    private static final String TEMPLATE_PACKAGE_NAME = "templatepkg.TemplateCodeImpl";

    /**
     * Return the created segment tree root node from the source code.
     *
     * @param sourceCode Content to parse.
     * @param config     Configurations obj.
     * @return Root segment node.
     */
    protected Segment getSegment(String sourceCode, QuoterConfig config) {
        NodeSegmentFactory generator = NodeSegmentFactory.fromConfig(config);

        TextDocument sourceCodeDocument = TextDocuments.from(sourceCode);
        Node syntaxTreeNode = SyntaxTree.from(sourceCodeDocument).rootNode();
        return generator.createNodeSegment(syntaxTreeNode);
    }

    /**
     * Creates a segment tree and run it via dynamic class loading.
     *
     * @param sourceCode   Input source code
     * @param formatter    Base formatter name to use.
     * @param templateFile Template to use for dynamic class loading.
     * @return Output from the generated code.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected SyntaxTree createSegmentAndRun(String sourceCode, String formatter, String templateFile) {
        try {
            int tabSpace = 2;
            QuoterConfig config = new TestQuoterConfig(templateFile, tabSpace, formatter);
            Segment segment = getSegment(sourceCode, config);
            String javaCode = SegmentFormatter.getFormatter(config).format(segment);

            ClassLoader classLoader = new ClassLoader() {
            };
            CachedCompiler compiler = new CachedCompiler(null, null);
            Class templateCodeImpl = compiler.loadFromJava(classLoader, TEMPLATE_PACKAGE_NAME, javaCode);
            TemplateCode templateCode = (TemplateCode) templateCodeImpl.getDeclaredConstructor().newInstance();

            return templateCode.getNode().syntaxTree();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Creates a segment tree and run it via dynamic class loading.
     * Then reads the name and check if the output from the generated code
     * is the same as the source code.
     *
     * @param sourceCode   Input source code.
     * @param formatter    Base formatter name to use.
     * @param templateFile Template to use for dynamic class loading.
     */
    protected void testForGeneratedCode(String sourceCode, String formatter, String templateFile) {
        sourceCode = sourceCode.trim();
        SyntaxTree tree = createSegmentAndRun(sourceCode, formatter, templateFile);
        Assert.assertEquals(tree.toSourceCode().trim(), sourceCode);
    }

    /**
     * Tests if the generated code for the given source code (after being formatted with all the formatters)
     * is valid and the generated code creates the same source code when run.
     *
     * @param sourceCode Input source code
     */
    protected void testAssertionContent(String sourceCode) {
        testForGeneratedCode(sourceCode, "default", "template-default.java");
        testForGeneratedCode(sourceCode, "variable", "template-variable.java");
        testForGeneratedCode(sourceCode, "none", "template-default.java");
    }

    /**
     * Tests if the generated code for the given file (after being formatted with all the formatters)
     * is valid and the generated code creates the same source code when run.
     *
     * @param directory  Name of the directory.
     * @param filePrefix File name without .bal.
     */
    protected void testAssertionFiles(String directory, String filePrefix) {
        String fileName = directory + "/" + filePrefix + ".bal";
        String sourceCode = FileReaderUtils.readFileAsResource(fileName).trim();
        testAssertionContent(sourceCode);
    }
}
