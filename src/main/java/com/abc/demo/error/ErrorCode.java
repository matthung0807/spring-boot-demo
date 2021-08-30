package com.abc.demo.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    WRONG_URI_PARAMS_FORMAT(
            HttpStatus.BAD_REQUEST,
            "Wrong URI Parameters Format",
            "http://localhost:8080/errortype.html#wrong-uri-params");

    private final HttpStatus httpStatus;
    private final String title;
    private final String type;

}
