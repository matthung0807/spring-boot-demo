package com.abc.demo.service;

import com.abc.demo.entity.Todo;
import com.abc.demo.model.PageModel;
import com.abc.demo.model.TodoModel;
import com.abc.demo.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public void add(String desc) {
        if (StringUtils.isEmpty(desc)) {
            throw new IllegalArgumentException("desc is empty");
        }

        Date currentTime = new Date();
        Todo todo = new Todo();
        todo.setDesc(desc);
        todo.setCreateTime(currentTime);
        todo.setUpdateTime(currentTime);
        todoRepository.save(todo);
    }

    @Transactional
    public void update(long id, String desc) {
        if (StringUtils.isEmpty(desc)) {
            throw new IllegalArgumentException("desc is empty");
        }
        Todo todo = todoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        todo.setDesc(desc);
        todo.setUpdateTime(new Date());
    }

    @Transactional
    public void delete(long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        todo.setDeleteFlag(true);
    }

    /**
     *
     * @param page 查詢的頁數
     * @param size 查詢的每頁筆數
     */
    public PageModel<TodoModel> getPagedTodoList(int page, int size) {
        int pageIndex= page - 1;
        Page<Todo> pageResult = todoRepository.findByDeleteFlag(false, PageRequest.of(pageIndex, size, Sort.by("id")));
        List<TodoModel> todoList = pageResult.getContent().stream().map(TodoModel::of).collect(Collectors.toList());

        PageModel<TodoModel> pageModel = new PageModel<>(todoList);
        pageModel.setTotalItems(pageResult.getTotalElements());
        pageModel.setTotalPages(pageResult.getTotalPages());
        return pageModel;
    }

    public TodoModel getById(long id) {
        return todoRepository.findById(id).map(TodoModel::of).orElseThrow(EntityNotFoundException::new);
    }
}
