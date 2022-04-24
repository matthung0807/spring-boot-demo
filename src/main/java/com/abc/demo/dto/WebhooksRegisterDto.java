package com.abc.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class WebhooksRegisterDto {
    private String name;
    private String url;
    private LocalDateTime createdAt;
}
