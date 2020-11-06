package com.abc.demo.service;

import com.abc.demo.controller.request.DemoRequest;
import com.abc.demo.validation.group.Group1;
import com.abc.demo.validation.group.Group2;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
@Service
public class DemoService {

    public void valid(@Valid DemoRequest request) {
        System.out.println(request);
    }

    @Validated(Group1.class)
    public void validGroup1(@Valid DemoRequest request) {
        System.out.println(request);
    }

    @Validated(Group2.class)
    public void validGroup2(@Valid DemoRequest request) {
        System.out.println(request);
    }
}
