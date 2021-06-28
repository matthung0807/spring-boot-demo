package com.abc.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DemoController {

    @GetMapping("/langs")
    public List<String> getLangs() {
        return Arrays.asList(
                "C",
                "C++",
                "C#",
                "Erlang",
                "Go",
                "Groovy",
                "Java",
                "JavaScript",
                "PHP",
                "Python",
                "Ruby",
                "Scala"
        );
    }
}
