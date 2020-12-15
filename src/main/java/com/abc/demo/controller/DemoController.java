package com.abc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/hello")
    public ModelAndView hello() {
        return new ModelAndView("hello"); // 根據view resolver mapping至hello.jsp
    }
}
