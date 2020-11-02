package io.ballerinalang.quoter.test.unit;

import io.ballerinalang.quoter.formatter.DefaultFormatter;
import io.ballerinalang.quoter.segment.CodeSegment;
import io.ballerinalang.quoter.segment.Segment;
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
        String target = "A(\n\tB()\n)";
        assertTest(source, target);

        source = "A(B(C()))";
        target = "A(\n\tB(\n\t\tC()\n\t)\n)";
        assertTest(source, target);
    }

    @Test
    public void testComma() {
        String source = "A(\"Hello\",\"Hi\")";
        String target = "A(\n\t\"Hello\",\n\t\"Hi\"\n)";
        assertTest(source, target);
    }

    @Test
    public void testCommaParenthesis() {
        String source = "A(B(),C())";
        String target = "A(\n\tB(),\n\tC()\n)";
        assertTest(source, target);

        source = "A(B(),C(E()),D())";
        target = "A(\n\tB(),\n\tC(\n\t\tE()\n\t),\n\tD()\n)";
        assertTest(source, target);
    }
}
