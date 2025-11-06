package com.abc.demo.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.demo.dto.TodoDto;
import com.abc.demo.service.TodoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/all")
    public List<TodoDto> getAll() {
        return todoService.getAll();
    }

    @PostMapping("/todo")
    public void create(@RequestBody TodoDto todoDto) {
        if (StringUtils.isBlank(todoDto.getDesc())) {
            throw new IllegalArgumentException("Description cannot be empty");
        }
        todoService.create(todoDto.getDesc());
    }

    @DeleteMapping("/todo/{id}")
    public void delete(@PathVariable long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        todoService.delete(id);
    }

    @PutMapping("/todo/{id}")
    public void update(@PathVariable long id, @RequestBody TodoDto todoDto) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
        todoService.update(id, todoDto);
    }

}
