package com.abc.demo.service;

import com.abc.demo.controller.request.DemoRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

@SpringBootTest
class DemoServiceTests {

    @Autowired
    private DemoService demoService;

    /**
     * 只檢核@Positive<br>
     *     id大於0。通過
     */
    @Test
    void valid_pass() {
        DemoRequest request = DemoRequest.builder()
                .id(1L) // id大於0
                .email("abc.com") // 信箱格式錯誤
                .age(7) // 年齡小於18歲
                .build();

        Assertions.assertDoesNotThrow(() -> demoService.valid(request));
    }

    /**
     * 只檢核@Positive<br>
     *     id小於0。不通過
     */
    @Test
    void valid_notPass() {
        DemoRequest request = DemoRequest.builder()
                .id(-1L) // id小於0
                .email("abc.com") // 信箱格式錯誤
                .age(7) // 年齡小於18歲
                .build();

        Assertions.assertThrows(
                ConstraintViolationException.class,
                () -> demoService.valid(request));
    }

    /**
     * 只檢核@Email<br>
     *     信箱格式正確。通過
     */
    @Test
    void validGroup1_pass() {

        DemoRequest request = DemoRequest.builder()
                .id(-1L) // id小於0
                .email("john@abc.com") // 信箱格式正確
                .age(7) // 年齡小於18歲
                .build();

        Assertions.assertDoesNotThrow(() -> demoService.validGroup1(request));

    }

    /**
     * 只檢核@Email<br>
     *     信箱格式錯誤。不通過
     */
    @Test
    void validGroup1_notPass() {

        DemoRequest request = DemoRequest.builder()
                .id(-1L) // id小於0
                .email("abc.com") // 信箱格式錯誤
                .age(7) // 年齡小於18歲
                .build();

        Assertions.assertThrows(
                ConstraintViolationException.class,
                () -> demoService.validGroup1(request));

    }

    /**
     * 只檢核@Min<br>
     *     年齡大於18歲。通過
     */
    @Test
    void validGroup2_pass() {

        DemoRequest request = DemoRequest.builder()
                .id(-1L) // id小於0
                .email("abc.com") // 信箱格式錯誤
                .age(21) // 年齡大於18歲
                .build();

        Assertions.assertDoesNotThrow(() -> demoService.validGroup2(request));

    }

    /**
     * 只檢核@Min<br>
     *     年齡小於18歲。不通過
     */
    @Test
    void validGroup2_notPass() {

        DemoRequest request = DemoRequest.builder()
                .id(-1L) // id小於0
                .email("abc.com") // 信箱格式錯誤
                .age(7) // 年齡小於18歲
                .build();

        Assertions.assertThrows(
                ConstraintViolationException.class,
                () -> demoService.validGroup2(request));

    }

}
