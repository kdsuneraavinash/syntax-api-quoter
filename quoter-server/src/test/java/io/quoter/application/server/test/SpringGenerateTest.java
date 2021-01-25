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

package io.quoter.application.server.test;

import org.testng.annotations.Test;

/**
 * Test Spring boot endpoints.
 */
public class SpringGenerateTest extends AbstractSpringTest {
    @Test
    public void testCode1() throws Exception {
        testAssertionFiles("testcases/code-1.bal");
    }

    @Test
    public void testCode2() throws Exception {
        testAssertionFiles("testcases/code-2.bal");
    }

    @Test
    public void testCode3() throws Exception {
        testAssertionFiles("testcases/code-3.bal");
    }

    @Test
    public void testCode4() throws Exception {
        testAssertionFiles("testcases/code-4.bal");
    }

    @Test
    public void testCode5() throws Exception {
        testAssertionFiles("testcases/code-5.bal");
    }
}
