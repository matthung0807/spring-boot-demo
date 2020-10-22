package com.abc.demo.controller;

import com.abc.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService employeeService;

    @GetMapping("/employee/modify/{id}/{name}")
    public void modify(@PathVariable long id, @PathVariable String name) {
        employeeService.modifyName(id, name);
    }

}
