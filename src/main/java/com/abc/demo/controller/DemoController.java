package com.abc.demo.controller;

import com.abc.demo.controller.exception.DemoException;
import com.abc.demo.error.ErrorCode;
import com.abc.demo.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
public class DemoController {

    @GetMapping("/employees/{name}")
    public List<Employee> getEmployees(@PathVariable String name) {

        if (Pattern.compile("\\d").matcher(name).find()) {
            throw new DemoException(
                    ErrorCode.WRONG_URI_PARAMS_FORMAT,
                    "URI parameter {name} cannot contains digit",
                    "/employees/" + name,
                    null
            );
        }

        return findEmployeesByName(name);
    }

    private List<Employee> findEmployeesByName(String name) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "John", 33),
                new Employee(2, "Mary", 28),
                new Employee(3, "Jason", 45)
        );

        return employeeList.stream()
                .filter(e -> isStartWith(e.getName(), name))
                .collect(Collectors.toList());
    }

    private boolean isStartWith(String name, String startStr) {
        return Pattern.compile("^" + startStr).matcher(name).find();
    }

}

