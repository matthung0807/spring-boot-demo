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

    /**
     * 只檢核@Positive<br>
     *     id大於0。通過
     */
    @Test
    void valid_pass() throws Exception {

        DemoRequest request = DemoRequest.builder()
                .id(1L) // id大於0
                .email("abc.com") // 信箱格式錯誤
                .age(7) // 年齡小於18歲
                .build();

        String json = new ObjectMapper().writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/valid")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    /**
     * 只檢核@Positive<br>
     *     id小於0。不通過
     */
    @Test
    void valid_notPass() throws Exception {

        DemoRequest request = DemoRequest.builder()
                .id(-1L) // id小於0
                .email("abc.com") // 信箱格式錯誤
                .age(7) // 年齡小於18歲
                .build();

        String json = new ObjectMapper().writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/valid")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    /**
     * 檢核@@Positive，@Email<br>
     *     id大於0，信箱格式正確。通過
     */
    @Test
    void validGroup1_pass() throws Exception {

        DemoRequest request = DemoRequest.builder()
                .id(1L) // id大於0
                .email("john@abc.com") // 信箱格式正確
                .age(7) // 年齡小於18歲
                .build();

        String json = new ObjectMapper().writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/valid/group1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    /**
     * 檢核@@Positive，@Email<br>
     *     id大於0，信箱格式錯誤。通過
     */
    @Test
    void validGroup1_notPass() throws Exception {

        DemoRequest request = DemoRequest.builder()
                .id(1L) // id大於0
                .email("abc.com") // 信箱格式錯誤
                .age(7) // 年齡小於18歲
                .build();

        String json = new ObjectMapper().writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/valid/group1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    /**
     * 檢核@@Positive，@Min<br>
     *     id大於0，年齡大於18歲。通過
     */
    @Test
    void validGroup2_pass() throws Exception {

        DemoRequest request = DemoRequest.builder()
                .id(1L) // id大於0
                .email("abc.com") // 信箱格式錯誤
                .age(21) // 年齡大於18歲
                .build();

        String json = new ObjectMapper().writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/valid/group2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    /**
     * 檢核@@Positive，@Min<br>
     *     id大於0，年齡小於18歲。不通過
     */
    @Test
    void validGroup2_notPass() throws Exception {

        DemoRequest request = DemoRequest.builder()
                .id(1L) // id大於0
                .email("abc.com") // 信箱格式錯誤
                .age(7) // 年齡小於18歲
                .build();

        String json = new ObjectMapper().writeValueAsString(request);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/valid/group2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

}
