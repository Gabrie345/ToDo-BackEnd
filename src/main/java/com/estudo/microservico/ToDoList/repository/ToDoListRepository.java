package com.estudo.microservico.ToDoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudo.microservico.ToDoList.domain.TodoDomain;

@Repository
public interface ToDoListRepository extends JpaRepository<TodoDomain, Integer>{


}
