package com.abc.demo.controller;

import com.abc.demo.controller.request.RegisterRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class RegisterControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void register_password_success() throws Exception {
        String account = "abc";
        String password = "abc123";
        RegisterRequest request = new RegisterRequest(account, password);
        String jsonString = toJsonString(request);
        mockMvc.perform(
                post("/register")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().string("success")
                );

    }

    @Test
    void register_password_fail() throws Exception {
        String account = "abc";
        String password = "ab1212";
        RegisterRequest request = new RegisterRequest(account, password);
        String jsonString = toJsonString(request);
        mockMvc.perform(
                post("/register")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().string("fail")
                );

    }

    @Test
    void register_password_null_fail() throws Exception {
        String account = "abc";
        String password = null;
        RegisterRequest request = new RegisterRequest(account, password);
        String jsonString = toJsonString(request);
        mockMvc.perform(
                post("/register")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isOk())
                .andExpect(content().string("fail")
                );

    }

    private String toJsonString(Object object) throws JsonProcessingException {
        return new ObjectMapper().writer().writeValueAsString(object);
    }
}
