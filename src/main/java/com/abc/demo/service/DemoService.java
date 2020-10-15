package com.abc.demo.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DemoService {

    private static Map<Long, String> nameMap = new HashMap<>();

    static {
        nameMap.put(1L, "jeff");
        nameMap.put(2L, "jack");
        nameMap.put(3L, "cady");
    }

    public String getName(long id) {
        return nameMap.get(id);
    }
}
