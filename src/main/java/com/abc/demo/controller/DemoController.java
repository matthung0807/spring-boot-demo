package com.abc.demo.controller;

import com.abc.demo.controller.request.DemoRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DemoController {

    @PostMapping("/valid")
    public void valid(@RequestBody @Valid DemoRequest request) {
        System.out.println(request);
    }

}
