package com.abc.demo.controller;

import com.abc.demo.controller.request.DemoRequest;
import com.abc.demo.validation.group.Group1;
import com.abc.demo.validation.group.Group2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@Validated
@RestController
public class DemoController {

    @PostMapping("/valid")
    public void valid(@RequestBody @Valid DemoRequest request) {
    }

    @Validated(Group1.class)
    @PostMapping("/valid/group1")
    public void validGroup1(@RequestBody @Valid DemoRequest request) {
    }

    @Validated(Group2.class)
    @PostMapping("/valid/group2")
    public void validGroup2(@RequestBody @Valid DemoRequest request) {
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
