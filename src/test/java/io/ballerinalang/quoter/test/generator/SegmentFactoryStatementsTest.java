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

import io.ballerinalang.quoter.test.AbstractQuoterTest;
import org.testng.annotations.Test;

/**
 * Test statements to segment conversion.
 */
public class SegmentFactoryStatementsTest extends AbstractQuoterTest {
    @Test
    public void testBlockStatement() {
        testAssertionFiles("parser/statements/block-stmt", "block_stmt_source_01");
        testAssertionFiles("parser/statements/block-stmt", "block_stmt_source_02");
        testAssertionFiles("parser/statements/block-stmt", "block_stmt_source_03");
    }

    @Test
    public void testCallStatement() {
        testAssertionFiles("parser/statements/call-stmt", "call_stmt_source_01");
        testAssertionFiles("parser/statements/call-stmt", "call_stmt_source_02");
        testAssertionFiles("parser/statements/call-stmt", "call_stmt_source_05");
        testAssertionFiles("parser/statements/call-stmt", "call_stmt_source_06");
    }

    @Test
    public void testDestructuringAssignment() {
        testAssertionFiles("parser/statements/destructuring-assignment", "error_binding_pattern_source_01");
        testAssertionFiles("parser/statements/destructuring-assignment", "mapping_binding_pattern_source_01");
    }

    @Test
    public void testDoStatement() {
        testAssertionFiles("parser/statements/do-stmt", "do_stmt_source_01");
        testAssertionFiles("parser/statements/do-stmt", "do_stmt_source_02");
        testAssertionFiles("parser/statements/do-stmt", "do_stmt_source_03");
    }

    @Test
    public void testFailStatement() {
        testAssertionFiles("parser/statements/fail-stmt", "fail_stmt_source_01");
        testAssertionFiles("parser/statements/fail-stmt", "fail_stmt_source_02");
    }

    @Test
    public void testForEachStatement() {
        testAssertionFiles("parser/statements/forEach-stmt", "forEach_stmt_source_01");
        testAssertionFiles("parser/statements/forEach-stmt", "forEach_stmt_source_02");
        testAssertionFiles("parser/statements/forEach-stmt", "forEach_stmt_source_03");
    }

    @Test
    public void testForkStatement() {
        testAssertionFiles("parser/statements/fork-stmt", "fork_stmt_source_01");
        testAssertionFiles("parser/statements/fork-stmt", "fork_stmt_source_02");
        testAssertionFiles("parser/statements/fork-stmt", "fork_stmt_source_03");
    }

    @Test
    public void testIfElseStatement() {
        testAssertionFiles("parser/statements/if-else", "if_else_source_01");
        testAssertionFiles("parser/statements/if-else", "if_else_source_02");
    }

    @Test
    public void testLockStatement() {
        testAssertionFiles("parser/statements/lock-stmt", "lock_stmt_source_01");
        testAssertionFiles("parser/statements/lock-stmt", "lock_stmt_source_02");
        testAssertionFiles("parser/statements/lock-stmt", "lock_stmt_source_03");
    }

    @Test
    public void testMatchStatement() {
        testAssertionFiles("parser/statements/match-stmt", "match_stmt_source_01");
        testAssertionFiles("parser/statements/match-stmt", "match_stmt_source_02");
        testAssertionFiles("parser/statements/match-stmt", "match_stmt_source_05");
        testAssertionFiles("parser/statements/match-stmt", "match_stmt_source_08");
        testAssertionFiles("parser/statements/match-stmt", "match_stmt_source_14");
        testAssertionFiles("parser/statements/match-stmt", "match_stmt_source_16");
    }

    @Test
    public void testTransactionStatement() {
        testAssertionFiles("parser/statements/transaction-stmt", "retry_stmt_source_01");
        testAssertionFiles("parser/statements/transaction-stmt", "retry_stmt_source_02");
        testAssertionFiles("parser/statements/transaction-stmt", "retry_stmt_source_05");
        testAssertionFiles("parser/statements/transaction-stmt", "rollback_stmt_source_01");
        testAssertionFiles("parser/statements/transaction-stmt", "transaction_stmt_source_01");
        testAssertionFiles("parser/statements/transaction-stmt", "transaction_stmt_source_03");
        testAssertionFiles("parser/statements/transaction-stmt", "transactional_worker_source_01");
    }

    @Test
    public void testWhileStatement() {
        testAssertionFiles("parser/statements/while-stmt", "while_stmt_source_01");
        testAssertionFiles("parser/statements/while-stmt", "while_stmt_source_02");
        testAssertionFiles("parser/statements/while-stmt", "while_stmt_source_04");
    }

    @Test
    public void testXmlnsDeclarationStatement() {
        testAssertionFiles("parser/statements/xmlns-decl-stmt", "xmlns_decl_stmt_source_01");
    }
}
