package com.example.testingtheweblayer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void hello_returnsDefaultMessage() throws Exception {
        // when
        ResultActions result = mockMvc.perform(get("/hello"))
                                      .andDo(print());

        // then
        result.andExpect(status().isOk())
              .andExpect(content().string(containsString("Hello, World")));

    }
}
