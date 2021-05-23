package com.abc.demo.controller;

import com.abc.demo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String hello(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);

        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("John");
        employee1.setAge(29);

        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("Anne");
        employee2.setAge(22);

        List<Employee> employeeList = Arrays.asList(employee1, employee2);
        model.addAttribute("employeeList", employeeList);

        return "hello"; // forward to hello.html
    }
}
