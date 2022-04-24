package com.abc.demo.controller.request;

import lombok.Data;

@Data
public class WebhooksRegisterRequest {
    private String name;
    private String url;
}
