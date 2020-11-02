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
 * Test expressions to segment conversion.
 */
public class SegmentFactoryExpressionsTest extends AbstractQuoterTest {
    @Test
    public void testAnonFunc() {
        testAssertionFiles("parser/expressions/anon-func", "anon_func_source_01");
        testAssertionFiles("parser/expressions/anon-func", "anon_func_source_02");
        testAssertionFiles("parser/expressions/anon-func", "anon_func_source_04");
        testAssertionFiles("parser/expressions/anon-func", "anon_func_source_07");
        testAssertionFiles("parser/expressions/anon-func", "anon_func_source_09");
        testAssertionFiles("parser/expressions/anon-func", "anon_func_source_11");
    }

    @Test
    public void testBasicLiterals() {
        testAssertionFiles("parser/expressions/basic-literals", "float_literal_source_01");
        testAssertionFiles("parser/expressions/basic-literals", "float_literal_source_02");
        testAssertionFiles("parser/expressions/basic-literals", "float_literal_source_03");
        testAssertionFiles("parser/expressions/basic-literals", "float_literal_source_04");
        testAssertionFiles("parser/expressions/basic-literals", "float_literal_source_05");
        testAssertionFiles("parser/expressions/basic-literals", "nil_literal_source_01");
        testAssertionFiles("parser/expressions/basic-literals", "nil_literal_source_02");
        testAssertionFiles("parser/expressions/basic-literals", "nil_literal_source_03");
        testAssertionFiles("parser/expressions/basic-literals", "nil_literal_source_04");
    }

    @Test
    public void testByteArrayLiteral() {
        testAssertionFiles("parser/expressions/byte-array-literal", "base16_literal_source_01");
        testAssertionFiles("parser/expressions/byte-array-literal", "base64_literal_source_01");
    }

    @Test
    public void testCheckExpr() {
        testAssertionFiles("parser/expressions/check-expr", "check_expr_source_01");
        testAssertionFiles("parser/expressions/check-expr", "check_expr_source_02");
        testAssertionFiles("parser/expressions/check-expr", "check_expr_source_03");
    }

    @Test
    public void testErrorConstructorExpr() {
        testAssertionFiles("parser/expressions/error-constructor-expr", "error_constructor_expr_source_01");
    }

    @Test
    public void testFuncCall() {
        testAssertionFiles("parser/expressions/func-call", "func_call_source_12");
    }

    @Test
    public void testNewExpr() {
        testAssertionFiles("parser/expressions/new-expr", "explicit-new-with-object-keyword-with-no-args");
        testAssertionFiles("parser/expressions/new-expr", "explicit-new-with-object-keyword-with-one-args");
    }

    @Test
    public void testObjectConstructor() {
        testAssertionFiles("parser/expressions/object-constructor", "object-constructor-with-annotations");
        testAssertionFiles("parser/expressions/object-constructor", "object-constructor-with-basic-object-fields");
        testAssertionFiles("parser/expressions/object-constructor", "object-constructor-with-client-keyword");
        testAssertionFiles("parser/expressions/object-constructor", "object-constructor-with-type-reference");
        testAssertionFiles("parser/expressions/object-constructor", "object_constructor_source_05");
        testAssertionFiles("parser/expressions/object-constructor", "object_constructor_source_08");
    }

    @Test
    public void testServiceConstructorExpression() {
        testAssertionFiles("parser/expressions/service-constructor-expression", "service_constructor_expr_source_01");
        testAssertionFiles("parser/expressions/service-constructor-expression", "service_constructor_expr_source_02");
    }

    @Test
    public void testStringTemplate() {
        testAssertionFiles("parser/expressions/string-template", "string_template_source_01");
        testAssertionFiles("parser/expressions/string-template", "string_template_source_02");
    }

    @Test
    public void testTransactionalExpr() {
        testAssertionFiles("parser/expressions/transactional-expr", "transactional_expr_source_01");
    }

    @Test
    public void testTrapExpr() {
        testAssertionFiles("parser/expressions/trap-expr", "trap_expr_source_01");
        testAssertionFiles("parser/expressions/trap-expr", "trap_expr_source_02");
        testAssertionFiles("parser/expressions/trap-expr", "trap_expr_source_03");
    }

    @Test
    public void testTypeofExpr() {
        testAssertionFiles("parser/expressions/typeof-expr", "typeof_expr_source_01");
        testAssertionFiles("parser/expressions/typeof-expr", "typeof_expr_source_02");
        testAssertionFiles("parser/expressions/typeof-expr", "typeof_expr_source_03");
    }

    @Test
    public void testXmlTemplate() {
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_01");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_02");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_06");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_07");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_11");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_12");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_14");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_15");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_16");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_21");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_23");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_25");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_26");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_29");
        testAssertionFiles("parser/expressions/xml-template", "xml_template_source_30");
    }
}
