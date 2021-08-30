package com.abc.demo.controller.exception;

import com.abc.demo.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DemoException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String detail;
    private final String instance;
    private final Exception exception;

}
