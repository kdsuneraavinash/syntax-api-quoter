package io.ballerinalang.quoter.test.spring;

import org.testng.annotations.Test;

/**
 * Test Spring boot endpoints.
 */
public class SpringGenerateTest extends AbstractSpringTest {
    @Test
    public void testCode1() throws Exception {
        testAssertionFiles("general/code-1.bal");
    }

    @Test
    public void testCode2() throws Exception {
        testAssertionFiles("general/code-2.bal");
    }

    @Test
    public void testCode3() throws Exception {
        testAssertionFiles("general/code-3.bal");
    }

    @Test
    public void testCode4() throws Exception {
        testAssertionFiles("general/code-4.bal");
    }

    @Test
    public void testCode5() throws Exception {
        testAssertionFiles("general/code-5.bal");
    }
}
