package com.abc.demo.controller;

import com.abc.demo.controller.request.HelloRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello(@RequestBody HelloRequest helloRequest) {
        System.out.println("Hello " + helloRequest.getName());

        return "success";
    }
}
