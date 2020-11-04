package io.ballerina.quoter.unit;

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
