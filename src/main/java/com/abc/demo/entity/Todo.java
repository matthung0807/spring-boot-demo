package com.abc.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Table(name = "TODO")
@Entity
public class Todo implements Serializable {
    private static final Long serialVersionUID = 1L;

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private long id;

    private String desc;

    @NonNull
    private Date createTime;

    @NonNull
    private Date updateTime;

    private boolean deleteFlag;
}
