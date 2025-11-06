package com.abc.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abc.demo.dto.TodoDto;
import com.abc.demo.entity.Todo;
import com.abc.demo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public List<TodoDto> getAll() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(this::convertToDto).toList();
    }

    private TodoDto convertToDto(Todo todo) {
        TodoDto dto = new TodoDto();
        dto.setId(todo.getId());
        dto.setDesc(todo.getDesc());
        dto.setCreateAt(todo.getCreateAt());
        dto.setUpdateAt(todo.getUpdateAt());
        dto.setDeleted(todo.isDeleted());
        return dto;
    }

    public void create(String desc) {
        Todo todo = new Todo();
        todo.setDesc(desc);
        todo.setCreateAt(LocalDateTime.now());
        todo.setUpdateAt(LocalDateTime.now());
        todo.setDeleted(false);
        todoRepository.save(todo);
    }

    public void delete(long id) {
        todoRepository.deleteById(id);
    }

    public void update(long id, TodoDto todoDto) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Todo not found with id: " + id));
        todo.setDesc(todoDto.getDesc());
        todo.setUpdateAt(LocalDateTime.now());
        todo.setDeleted(todoDto.isDeleted());
        todoRepository.save(todo);
    }

}
