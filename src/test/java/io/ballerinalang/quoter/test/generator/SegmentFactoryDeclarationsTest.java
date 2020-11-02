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
 * Test declarations to segment conversion.
 */
public class SegmentFactoryDeclarationsTest extends AbstractQuoterTest {

    @Test
    public void testAnnotationDecl() {
        testAssertionFiles("parser/declarations/annot-decl", "annot_decl_source_01");
        testAssertionFiles("parser/declarations/annot-decl", "annot_decl_source_02");
        testAssertionFiles("parser/declarations/annot-decl", "annot_decl_source_03");
    }

    @Test
    public void testClassDef() {
        testAssertionFiles("parser/declarations/class-def", "class_def_source_01");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_02");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_03");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_04");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_11");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_12");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_13");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_14");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_24");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_25");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_27");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_28");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_36");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_38");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_40");
        testAssertionFiles("parser/declarations/class-def", "class_def_source_41");
    }

    @Test
    public void testEnumDecl() {
        testAssertionFiles("parser/declarations/enum-decl", "enum_decl_source_01");
        testAssertionFiles("parser/declarations/enum-decl", "enum_decl_source_03");
        testAssertionFiles("parser/declarations/enum-decl", "enum_decl_source_05");
        testAssertionFiles("parser/declarations/enum-decl", "enum_decl_source_06");
    }

    @Test
    public void testFuncDefinition() {
        testAssertionFiles("parser/declarations/func-definition", "func_def_source_01");
        testAssertionFiles("parser/declarations/func-definition", "func_def_source_02");
        testAssertionFiles("parser/declarations/func-definition", "func_def_source_05");
        testAssertionFiles("parser/declarations/func-definition", "func_def_source_08");
        testAssertionFiles("parser/declarations/func-definition", "func_def_source_11");
        testAssertionFiles("parser/declarations/func-definition", "func_def_source_14");
        testAssertionFiles("parser/declarations/func-definition", "func_def_source_26");
        testAssertionFiles("parser/declarations/func-definition", "func_params_source_01");
        testAssertionFiles("parser/declarations/func-definition", "func_params_source_05");
        testAssertionFiles("parser/declarations/func-definition", "func_params_source_08");
        testAssertionFiles("parser/declarations/func-definition", "isolated_func_def_01");
        testAssertionFiles("parser/declarations/func-definition", "isolated_func_def_02");
        testAssertionFiles("parser/declarations/func-definition", "isolated_func_def_03");
        testAssertionFiles("parser/declarations/func-definition", "isolated_func_def_04");
        testAssertionFiles("parser/declarations/func-definition", "isolated_func_def_05");
        testAssertionFiles("parser/declarations/func-definition", "isolated_func_def_06");
    }

    @Test
    public void testImportDecl() {
        testAssertionFiles("parser/declarations/import-decl", "import_decl_source_01");
        testAssertionFiles("parser/declarations/import-decl", "import_decl_source_02");
        testAssertionFiles("parser/declarations/import-decl", "import_decl_source_03");
        testAssertionFiles("parser/declarations/import-decl", "import_decl_source_04");
        testAssertionFiles("parser/declarations/import-decl", "import_decl_source_05");
        testAssertionFiles("parser/declarations/import-decl", "import_decl_source_06");
        testAssertionFiles("parser/declarations/import-decl", "import_decl_source_07");
        testAssertionFiles("parser/declarations/import-decl", "import_decl_source_08");
        testAssertionFiles("parser/declarations/import-decl", "import_decl_source_09");
        testAssertionFiles("parser/declarations/import-decl", "import_decl_source_18");
    }

    @Test
    public void testIsolatedObjectMethods() {
        testAssertionFiles("parser/declarations/isolated-object-methods", "isolated_object_method_source_01");
        testAssertionFiles("parser/declarations/isolated-object-methods", "isolated_object_method_source_03");
    }

    @Test
    public void testIsolatedServiceFunctions() {
        testAssertionFiles("parser/declarations/isolated-service-functions", "isolated_service_func_source_01");
        testAssertionFiles("parser/declarations/isolated-service-functions", "isolated_service_func_source_03");
    }

    @Test
    public void testObjectTypeDef() {
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_01");
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_02");
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_03");
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_04");
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_11");
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_12");
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_13");
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_16");
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_36");
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_38");
        testAssertionFiles("parser/declarations/object-type-def", "object_type_def_source_41");
    }

    @Test
    public void testRecordTypeDef() {
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_01");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_02");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_03");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_04");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_08");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_11");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_13");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_14");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_15");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_19");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_21");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_22");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_23");
        testAssertionFiles("parser/declarations/record-type-def", "record_type_def_source_25");
    }

    @Test
    public void testServiceDecl() {
        testAssertionFiles("parser/declarations/service-decl", "service_decl_source_01");
        testAssertionFiles("parser/declarations/service-decl", "service_decl_source_02");
        testAssertionFiles("parser/declarations/service-decl", "service_decl_source_06");
    }

    @Test
    public void testTransactionalResource() {
        testAssertionFiles("parser/declarations/transactional-resource", "transaction_resource_func_source_01");
    }

    @Test
    public void testXmlnsDecl() {
        testAssertionFiles("parser/declarations/xmlns-decl", "xmlns_decl_source_01");
        testAssertionFiles("parser/declarations/xmlns-decl", "xmlns_decl_source_06");
    }
}
