package com.abc.demo.controller;

import com.abc.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/test/{message}")
    public void test(@PathVariable String message) throws Exception {
        messageService.send(message);
    }

}