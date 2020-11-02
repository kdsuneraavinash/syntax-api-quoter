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

package io.ballerinalang.quoter;

import io.ballerina.compiler.syntax.tree.Node;
import io.ballerina.compiler.syntax.tree.SyntaxTree;
import io.ballerina.tools.text.TextDocument;
import io.ballerina.tools.text.TextDocuments;
import io.ballerinalang.quoter.config.QuoterConfig;
import io.ballerinalang.quoter.formatter.SegmentFormatter;
import io.ballerinalang.quoter.segment.Segment;
import io.ballerinalang.quoter.segment.factories.NodeSegmentFactory;

/**
 * Ballerina Quoter programme main class.
 * CLI will run via QuoterCommandLine
 */
public class BallerinaQuoter {
    /**
     * Run the process with the given configurations.
     */
    public static void run(QuoterConfig config) {
        try {
            // 1) Get the input file code
            String sourceCode = config.readInputFile();
            // 2) Create the factory
            NodeSegmentFactory factory = NodeSegmentFactory.fromConfig(config);
            // 3) Get the formatter
            SegmentFormatter formatter = SegmentFormatter.getFormatter(config);

            // 4) Execute the generator
            String generatedCode = execute(sourceCode, factory, formatter);

            // 5) Output the generated code
            config.writeToOutputFile(generatedCode);

        } catch (QuoterException exception) {
            throw exception;
        } catch (Exception exception) {
            throw new QuoterException("There was an Exception when parsing. Please check your code.", exception);
        }
    }

    /**
     * Execute the generator.
     * sourceCode -> [nodeSegmentFactory] -> segment -> [formatter] -> generatedCode
     *
     * @param sourceCode Ballerina code input.
     * @param factory    Node segment factory.
     * @param formatter  Formatter to use.
     * @return Java code to create the input ballerina code.
     */
    private static String execute(String sourceCode, NodeSegmentFactory factory,
                                  SegmentFormatter formatter) {
        // Create syntax tree
        TextDocument sourceCodeDocument = TextDocuments.from(sourceCode);
        Node syntaxTreeNode = SyntaxTree.from(sourceCodeDocument).rootNode();
        // Convert tree to segment
        Segment segment = factory.createNodeSegment(syntaxTreeNode);
        // Format using the formatter
        return formatter.format(segment);
    }
}
