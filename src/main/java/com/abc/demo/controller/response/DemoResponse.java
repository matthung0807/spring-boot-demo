package com.abc.demo.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DemoResponse {

    private String type;
    private String title;
    private int status;
    private String detail;
    private String instance;

}
