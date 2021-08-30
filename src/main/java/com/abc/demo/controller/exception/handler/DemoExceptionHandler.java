package com.abc.demo.controller.exception.handler;

import com.abc.demo.controller.exception.DemoException;
import com.abc.demo.controller.response.DemoResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoExceptionHandler {

    @ExceptionHandler({DemoException.class})
    public final ResponseEntity<DemoResponse> handleDemoException(DemoException ex) {
        DemoResponse demoResponse = new DemoResponse (
                ex.getErrorCode().getType(),
                ex.getErrorCode().getTitle(),
                ex.getErrorCode().getHttpStatus().value(),
                ex.getDetail(),
                ex.getInstance()
        );
        return ResponseEntity
                .status(ex.getErrorCode().getHttpStatus())
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(demoResponse);
    }
}
