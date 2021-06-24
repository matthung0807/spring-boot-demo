package com.abc.demo.controller;

import com.abc.demo.controller.request.DemoRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class DemoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void valid_pass() throws Exception {

        DemoRequest request = DemoRequest.builder()
                .id(1L)
                .startDate("2021-06-24")
                .endDate("2021-06-23")
                .build();

        String json = new ObjectMapper().writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/valid")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}
