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
 * Test types to segment conversion.
 */
public class SegmentFactoryTypesTest extends AbstractQuoterTest {
    @Test
    public void testArrayType() {
        testAssertionFiles("parser/types/array-type", "array_type_assert_01");
        testAssertionFiles("parser/types/array-type", "array_type_assert_02");
        testAssertionFiles("parser/types/array-type", "array_type_assert_03");
    }

    @Test
    public void testErrorType() {
        testAssertionFiles("parser/types/error-type", "error_type_assert_01");
        testAssertionFiles("parser/types/error-type", "error_type_assert_02");
        testAssertionFiles("parser/types/error-type", "error_type_assert_03");
    }

    @Test
    public void testFuncType() {
        testAssertionFiles("parser/types/func-type", "func_type_source_01");
        testAssertionFiles("parser/types/func-type", "func_type_source_02");
        testAssertionFiles("parser/types/func-type", "func_type_source_03");
        testAssertionFiles("parser/types/func-type", "func_type_source_04");
    }

    @Test
    public void testIntersectionType() {
        testAssertionFiles("parser/types/intersection-type", "intersection_type_source_01");
        testAssertionFiles("parser/types/intersection-type", "intersection_type_source_04");
        testAssertionFiles("parser/types/intersection-type", "intersection_type_source_06");
    }

    @Test
    public void testOptionalType() {
        testAssertionFiles("parser/types/optional-type", "optional_type_source_01");
        testAssertionFiles("parser/types/optional-type", "optional_type_source_02");
        testAssertionFiles("parser/types/optional-type", "optional_type_source_04");
    }

    @Test
    public void testParameterizedType() {
        testAssertionFiles("parser/types/parameterized-type", "parameterized_type_source_01");
        testAssertionFiles("parser/types/parameterized-type", "parameterized_type_source_11");
        testAssertionFiles("parser/types/parameterized-type", "parameterized_type_source_14");
    }

    @Test
    public void testSimpleType() {
        testAssertionFiles("parser/types/simple-types", "simple_types_source_01");
    }

    @Test
    public void testSingletonType() {
        testAssertionFiles("parser/types/singleton-type", "singleton_type_source_01");
        testAssertionFiles("parser/types/singleton-type", "singleton_type_source_02");
        testAssertionFiles("parser/types/singleton-type", "singleton_type_source_03");
    }

    @Test
    public void testStreamType() {
        testAssertionFiles("parser/types/stream-type", "stream_type_source_01");
        testAssertionFiles("parser/types/stream-type", "stream_type_source_03");
        testAssertionFiles("parser/types/stream-type", "stream_type_source_04");
    }

    @Test
    public void testTableType() {
        testAssertionFiles("parser/types/table-type", "table_type_source_01");
        testAssertionFiles("parser/types/table-type", "table_type_source_06");
        testAssertionFiles("parser/types/table-type", "table_type_source_07");
    }

    @Test
    public void testTupleType() {
        testAssertionFiles("parser/types/tuple-type", "tuple_type_source_01");
        testAssertionFiles("parser/types/tuple-type", "tuple_type_source_02");
        testAssertionFiles("parser/types/tuple-type", "tuple_type_source_03");
    }

    @Test
    public void testUnionType() {
        testAssertionFiles("parser/types/union-type", "union_type_assert_01");
        testAssertionFiles("parser/types/union-type", "union_type_assert_02");
    }
}
