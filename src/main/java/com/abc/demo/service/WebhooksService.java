package com.abc.demo.service;

import com.abc.demo.controller.request.WebhooksRegisterRequest;
import com.abc.demo.dto.WebhooksRegisterDto;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class WebhooksService {

    private final Map<String, WebhooksRegisterDto> registeredMap = new ConcurrentHashMap<>();

    public void save(WebhooksRegisterRequest webhooksRegisterRequest) {
        var url = webhooksRegisterRequest.getUrl();
        registeredMap.put(url, new WebhooksRegisterDto(
                webhooksRegisterRequest.getName(), url, LocalDateTime.now()));
    }

    public List<WebhooksRegisterDto> getRegisteredDtoList() {
        return registeredMap.values().stream().toList();
    }

    public List<String> getRegisteredUrlList() {
        return registeredMap.values().stream()
                .toList().stream()
                .map(WebhooksRegisterDto::getUrl).toList();
    }

}
