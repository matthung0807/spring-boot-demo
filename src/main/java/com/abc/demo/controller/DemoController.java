package com.abc.demo.controller;

import com.abc.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name); // set request attribute

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("John");
        employee.setAge(29);

        model.addAttribute("employee", employee);

        return "hello"; // forward to hello.html
    }
}
