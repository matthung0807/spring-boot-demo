package com.abc.demo.controller;

import com.abc.demo.controller.request.WebhooksRegisterRequest;
import com.abc.demo.service.WebhooksService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
public class WebHooksController {

    @Autowired
    private WebhooksService webhooksService;

    @Value("classpath:static/webhooks/events.yaml")
    private Resource eventsYaml;

    @PostMapping(value = "/register", produces = "text/yaml")
    public String register(@RequestBody WebhooksRegisterRequest webhooksRegisterRequest) throws IOException {
        webhooksService.save(webhooksRegisterRequest);
        return IOUtils.toString(eventsYaml.getInputStream(), StandardCharsets.UTF_8);
    }

    @GetMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getUrlList() {
        return webhooksService.getRegisteredUrlList();
    }

}
