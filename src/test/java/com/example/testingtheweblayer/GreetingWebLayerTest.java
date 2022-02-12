package com.example.testingtheweblayer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
public class GreetingWebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GreetingsService service;

    @Test
    void greeting_returnsGreetings() throws Exception {
        // given
        given(service.greet()).willReturn("Mocked greetings");

        // when
        ResultActions result = mockMvc.perform(get("/greeting"))
                                      .andDo(print());

        // then
        result.andExpect(status().isOk())
              .andExpect(content().string(containsString("Mocked greetings")));

    }
}
