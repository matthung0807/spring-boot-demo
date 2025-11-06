package com.abc.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class TodoDto {

    private long id;
    private String desc;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private boolean deleted;

}
