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

package io.ballerina.quoter.test.unit;

import io.ballerina.quoter.formatter.DefaultFormatter;
import io.ballerina.quoter.segment.CodeSegment;
import io.ballerina.quoter.segment.Segment;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test Default formatter base properties.
 */
public class DefaultFormatterTest {
    private void assertTest(String input, String expected) {
        Segment source = new CodeSegment(input);
        String target = new DefaultFormatter().format(source);
        Assert.assertEquals(target, expected);
    }

    @Test
    public void testSimpleInputs() {
        assertTest("A()", "A()");
        assertTest("A(\"Hello\")", "A(\"Hello\")");
        assertTest("A(SyntaxKind.abc)", "A(SyntaxKind.abc)");
    }

    @Test
    public void testParenthesis() {
        String source = "A(B())";
        String target = "A(\n" +
                "    B()\n" +
                ")";
        assertTest(source, target);

        source = "A(B(C()))";
        target = "A(\n" +
                "    B(\n" +
                "        C()\n" +
                "    )\n" +
                ")";
        assertTest(source, target);
    }

    @Test
    public void testComma() {
        String source = "A(\"Hello\",\"Hi\")";
        String target = "A(\n" +
                "    \"Hello\",\n" +
                "    \"Hi\"\n" +
                ")";
        assertTest(source, target);
    }

    @Test
    public void testCommaParenthesis() {
        String source = "A(B(),C())";
        String target = "A(\n" +
                "    B(),\n" +
                "    C()\n" +
                ")";
        assertTest(source, target);

        source = "A(B(),C(E()),D())";
        target = "A(\n" +
                "    B(),\n" +
                "    C(\n" +
                "        E()\n" +
                "    ),\n" +
                "    D()\n" +
                ")";
        assertTest(source, target);
    }
}
