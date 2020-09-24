package com.abc.demo.service;

import com.abc.demo.properties.SystemProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    SystemProperties systemProperties;

    public void printSystemPropertiesValue() {
        System.out.println(systemProperties.getName());
        System.out.println(systemProperties.getVersion());
        System.out.println(systemProperties.getUrl());
        System.out.println(systemProperties.getPort());
    }
}
