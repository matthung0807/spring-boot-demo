package com.abc.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Employee implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    private Long id;

    private String name;

    private Integer age;

}
