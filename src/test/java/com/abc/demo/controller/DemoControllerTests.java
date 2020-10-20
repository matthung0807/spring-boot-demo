package com.abc.demo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.NestedServletException;

@AutoConfigureMockMvc
@SpringBootTest
class DemoControllerTests {

    @Autowired
    private MockMvc mockMvc;

    /**
     * 測試呼叫黑貓貨運出貨服務實作
     * @throws Exception
     */
    @Test
    void ship_callTcatShipperService() throws Exception {
        String url = "/ship/tcat/202010190000000001";
        mockMvc.perform(MockMvcRequestBuilders.post(url))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 測試呼叫郵局貨運出貨服務實作
     * @throws Exception
     */
    @Test
    void ship_callPostShipperService() throws Exception {
        String url = "/ship/post/202010190000000001";
        mockMvc.perform(MockMvcRequestBuilders.post(url))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * 測試呼叫不支援的貨運出貨服務實作
     */
    @Test
    void ship_callUnsupportedShipperService() throws Exception {
        String url = "/ship/other/202010190000000001";
        Assertions.assertThrows(
                NestedServletException.class,
                () -> mockMvc.perform(MockMvcRequestBuilders.post(url)));
    }

}
