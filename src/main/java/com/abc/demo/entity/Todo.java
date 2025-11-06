package com.abc.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name = "TODO")
@Entity
public class Todo {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private long id;

    private String desc;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private boolean deleted;

}
