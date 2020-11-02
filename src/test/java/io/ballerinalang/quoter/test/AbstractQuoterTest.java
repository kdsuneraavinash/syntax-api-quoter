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
package io.ballerinalang.quoter.test;

import io.ballerina.compiler.syntax.tree.Node;
import io.ballerina.compiler.syntax.tree.SyntaxTree;
import io.ballerina.tools.text.TextDocument;
import io.ballerina.tools.text.TextDocuments;
import io.ballerinalang.quoter.QuoterException;
import io.ballerinalang.quoter.config.QuoterConfig;
import io.ballerinalang.quoter.formatter.SegmentFormatter;
import io.ballerinalang.quoter.segment.Segment;
import io.ballerinalang.quoter.segment.factories.NodeSegmentFactory;
import net.openhft.compiler.CachedCompiler;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

/**
 * Test Base class with several helper functions.
 */
public class AbstractQuoterTest {
    /**
     * Reads a file from the test resource directory.
     *
     * @param path Path of the file. (root is test resources directory)
     * @return Content of the file.
     */
    protected static String readResource(String path) {
        ClassLoader classLoader = AbstractQuoterTest.class.getClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream(path)) {
            if (inputStream == null) {
                throw new QuoterException("File not found: " + path);
            }
            Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
            return scanner.hasNext() ? scanner.next() : "";
        } catch (IOException e) {
            throw new QuoterException("Failed to read " + path + ". Error: " + e.getMessage(), e);
        }
    }

    /**
     * Return the created segment tree root node from the file content.
     *
     * @param fileName File to parse.
     * @param config   Configurations obj.
     * @return Root segment node.
     */
    protected Segment getSegmentFromFile(String fileName, QuoterConfig config) {
        String sourceCode = readResource(fileName);
        NodeSegmentFactory generator = NodeSegmentFactory.fromConfig(config);

        TextDocument sourceCodeDocument = TextDocuments.from(sourceCode);
        Node syntaxTreeNode = SyntaxTree.from(sourceCodeDocument).rootNode();
        return generator.createNodeSegment(syntaxTreeNode);
    }

    /**
     * Creates a segment tree and run it via dynamic class loading.
     *
     * @param balFile      Input .bal source file path. (Root is the test resources)
     * @param formatter    Base formatter name to use.
     * @param templateFile Template to use for dynamic class loading.
     * @return Output from the generated code.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected SyntaxTree createSegmentAndRun(String balFile, String formatter, String templateFile) {
        try {
            int tabSpace = 2;
            QuoterConfig config = new TestQuoterConfig(templateFile, tabSpace, formatter);
            Segment segment = getSegmentFromFile(balFile, config);
            String javaCode = SegmentFormatter.getFormatter(config).format(segment);

            ClassLoader classLoader = new ClassLoader() {
            };
            CachedCompiler compiler = new CachedCompiler(null, null);
            Objects.requireNonNull(compiler);

            String className = "templatepkg.TemplateCodeImpl";
            Class templateCodeImpl = compiler.loadFromJava(classLoader, className, javaCode);
            TemplateCode templateCode = (TemplateCode) templateCodeImpl.getDeclaredConstructor().newInstance();

            return templateCode.getNode().syntaxTree();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Creates a segment tree and run it via dynamic class loading.
     * Then reads the name and check if the output from the generated code
     * is the same as the file.
     *
     * @param fileName     Name of the file to test.
     * @param formatter    Base formatter name to use.
     * @param templateFile Template to use for dynamic class loading.
     */
    protected void testForSameOutput(String fileName, String formatter, String templateFile) {
        SyntaxTree tree = createSegmentAndRun(fileName, formatter, templateFile);
        String targetCode = readResource(fileName);
        Assert.assertEquals(tree.toSourceCode().trim(), targetCode.trim());
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
        testForSameOutput(fileName, "default", "template-default.java");
        testForSameOutput(fileName, "variable", "template-variable.java");
        testForSameOutput(fileName, "none", "template-default.java");
    }
}
