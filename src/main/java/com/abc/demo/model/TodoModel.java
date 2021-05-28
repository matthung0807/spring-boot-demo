package com.abc.demo.model;

import com.abc.demo.entity.Todo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
public class TodoModel {

    private long id;
    private String desc;
    private Date createTime;
    private Date updateTime;

    public static TodoModel of(Todo todo) {
        TodoModel model = new TodoModel();
        BeanUtils.copyProperties(todo, model);
        return model;
    }

}
