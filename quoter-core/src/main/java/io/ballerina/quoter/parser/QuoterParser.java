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

package io.ballerina.quoter.parser;

import io.ballerina.compiler.syntax.tree.Node;
import io.ballerina.compiler.syntax.tree.SyntaxTree;
import io.ballerina.quoter.QuoterException;
import io.ballerina.quoter.config.QuoterConfig;
import io.ballerina.tools.diagnostics.Diagnostic;
import io.ballerina.tools.diagnostics.DiagnosticSeverity;
import io.ballerina.tools.text.TextDocument;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static io.ballerina.quoter.config.QuoterConfig.EXTERNAL_PARSER_NAME;
import static io.ballerina.quoter.config.QuoterConfig.EXTERNAL_PARSER_TIMEOUT;

/**
 * In this stage the correct syntax tree is identified.
 * The root node of the syntax tree must be the corresponding
 * type for the statement.
 * For an example, for a import declaration,
 * the tree that is parsed should have
 * {@code ImportDeclarationNode} as the root node.
 */
public abstract class QuoterParser {
    private static final String EXPRESSION_PARSER = "expression";
    private static final String STATEMENT_PARSER = "statement";
    private static final Set<String> SILENCED_ERRORS = Set.of("BCE0517");

    private final long timeoutMs;

    protected QuoterParser(long timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    /**
     * Creates a parser depending on the configuration given.
     */
    public static QuoterParser fromConfig(QuoterConfig config) {
        String parserName = config.getOrThrow(EXTERNAL_PARSER_NAME);
        long timeoutMs = Long.parseLong(config.getOrThrow(EXTERNAL_PARSER_TIMEOUT));
        switch (parserName) {
            case EXPRESSION_PARSER:
                return new ExpressionParser(timeoutMs);
            case STATEMENT_PARSER:
                return new StatementParser(timeoutMs);
            default:
                return new ModuleParser(timeoutMs);
        }
    }

    /**
     * Highlight and show the error position.
     *
     * @param textDocument Text document to extract source code.
     * @param diagnostic   Diagnostic to show.
     * @return The string with position highlighted.
     */
    public static String highlightDiagnostic(TextDocument textDocument,
                                             io.ballerina.tools.diagnostics.Diagnostic diagnostic) {
        // Get the source code
        String space = " ";
        String sourceLine = textDocument.line(diagnostic.location().lineRange().startLine().line()).text();
        int position = diagnostic.location().lineRange().startLine().offset();
        return String.format("%s%n%s%n%s^", diagnostic.message(), sourceLine, space.repeat(position));
    }

    /**
     * Creates and checks for errors in the syntax tree.
     *
     * @param document Document to parse.
     * @return Created syntax tree.
     * @throws QuoterException If tree contains errors.
     */
    protected SyntaxTree getSyntaxTree(TextDocument document) throws QuoterException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<SyntaxTree> future = executor.submit(() -> SyntaxTree.from(document));
        executor.shutdown();

        SyntaxTree tree;
        try {
            tree = future.get(timeoutMs, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new QuoterException("Parsing was interrupted.");
        } catch (ExecutionException e) {
            throw new QuoterException("Executor failure because " + e.getCause().getMessage());
        } catch (TimeoutException e) {
            future.cancel(true);
            throw new QuoterException("Parsing was timed out.");
        }

        for (Diagnostic diagnostic : tree.diagnostics()) {
            if (diagnostic.diagnosticInfo().severity() == DiagnosticSeverity.ERROR) {
                if (!SILENCED_ERRORS.contains(diagnostic.diagnosticInfo().code())) {
                    throw new QuoterException(highlightDiagnostic(document, diagnostic));
                }
            }
        }
        return tree;
    }

    /**
     * Parses a source code string into a Node.
     *
     * @param source Input source code statement.
     * @return Syntax tree for the source code.
     */
    public abstract Node parse(String source);

    /**
     * Helper assertion to throw if condition is not satisfied.
     *
     * @param condition Condition to check.
     * @param message   Error message if failed.
     * @throws QuoterException If condition is not satisfied.
     */
    protected void assertIf(boolean condition, String message) {
        if (!condition) {
            throw new QuoterException(message);
        }
    }
}
