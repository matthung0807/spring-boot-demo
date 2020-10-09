package com.abc.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Value("${app.name}")
    private String appName;

    public String getAppName() {
        return appName;
    }

}
