package com.abc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.demo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
