package io.ballerinalang.quoter.test.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

/**
 * Test Spring boot endpoints.
 */
public class SpringEndpointSmokeTest extends AbstractSpringTest {
    @Test
    public void testPostEndpoint() throws Exception {
        mockMvc.perform(post("/generate"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"));
    }

    @Test
    public void testGetEndpoint() throws Exception {
        mockMvc.perform(get("/index.html"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Ballerina Syntax API Quoter")));
    }
}
