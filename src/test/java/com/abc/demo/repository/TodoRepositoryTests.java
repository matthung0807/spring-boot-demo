package com.abc.demo.repository;

import com.abc.demo.entity.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class TodoRepositoryTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void findById_noException() {
        try {
            Optional<Todo> todoOpt = todoRepository.findById(1L);
            String desc = todoOpt.map(Todo::getDesc).orElse("");
            Assertions.assertEquals("item1", desc);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail();
        }
    }

    @Transactional
    @Test
    public void save_idIncrement() {
        Todo todo = new Todo();
        todo.setDesc("item3");

        Date currentTime = new Date();
        todo.setCreateTime(currentTime);
        todo.setUpdateTime(currentTime);
        todo = todoRepository.save(todo);

        Assertions.assertEquals(3, todo.getId());

    }

}
