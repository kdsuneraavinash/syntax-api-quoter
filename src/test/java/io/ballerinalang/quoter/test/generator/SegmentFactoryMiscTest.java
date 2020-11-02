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
 * Test misc to segment conversion.
 */
public class SegmentFactoryMiscTest extends AbstractQuoterTest {
    @Test
    public void testAmbiguity() {
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_01");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_04");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_05");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_07");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_08");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_12");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_14");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_15");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_17");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_19");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_20");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_21");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_22");
        testAssertionFiles("parser/misc/ambiguity", "ambiguity_source_23");
    }

    @Test
    public void testAnnotations() {
        testAssertionFiles("parser/misc/annotations", "annotations_source_01");
        testAssertionFiles("parser/misc/annotations", "annotations_source_02");
        testAssertionFiles("parser/misc/annotations", "annotations_source_04");
        testAssertionFiles("parser/misc/annotations", "annotations_source_07");
    }

    @Test
    public void testDocumentation() {
        testAssertionFiles("parser/misc/documentation", "doc_source_01");
        testAssertionFiles("parser/misc/documentation", "doc_source_02");
        testAssertionFiles("parser/misc/documentation", "doc_source_03");
        testAssertionFiles("parser/misc/documentation", "doc_source_04");
        testAssertionFiles("parser/misc/documentation", "doc_source_05");
        testAssertionFiles("parser/misc/documentation", "doc_source_06");
        testAssertionFiles("parser/misc/documentation", "doc_source_07");
        testAssertionFiles("parser/misc/documentation", "doc_source_08");
        testAssertionFiles("parser/misc/documentation", "doc_source_09");
        testAssertionFiles("parser/misc/documentation", "doc_source_10");
        testAssertionFiles("parser/misc/documentation", "doc_source_11");
        testAssertionFiles("parser/misc/documentation", "doc_source_12");
        testAssertionFiles("parser/misc/documentation", "doc_source_14");
        testAssertionFiles("parser/misc/documentation", "doc_source_15");
        testAssertionFiles("parser/misc/documentation", "doc_source_16");
        testAssertionFiles("parser/misc/documentation", "doc_source_17");
    }

    @Test
    public void testQuotedIdentifiers() {
        testAssertionFiles("parser/misc/quoted-identifiers", "alphanumeric_identifier_source");
        testAssertionFiles("parser/misc/quoted-identifiers", "invalid_identifier_source_02");
        testAssertionFiles("parser/misc/quoted-identifiers", "special_char_identifier_source");
        testAssertionFiles("parser/misc/quoted-identifiers", "unicode_char_identifier_source");
        testAssertionFiles("parser/misc/quoted-identifiers", "unicode_codepoint_source");
    }

    @Test
    public void testTypedBindingPatterns() {
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_01");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_02");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_03");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_04");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_05");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_06");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_10");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_11");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_14");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_15");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_17");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_19");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_20");
        testAssertionFiles("parser/misc/typed-binding-patterns", "typed_binding_patterns_source_21");
    }

    @Test
    public void testWorkerDeclaration() {
        testAssertionFiles("parser/misc/worker-decl", "worker_decl_source_01");
        testAssertionFiles("parser/misc/worker-decl", "worker_decl_source_02");
        testAssertionFiles("parser/misc/worker-decl", "worker_decl_source_04");
    }
}
