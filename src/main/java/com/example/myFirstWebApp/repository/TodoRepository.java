package com.example.myFirstWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myFirstWebApp.model.ToDo;

@Repository
public interface TodoRepository extends JpaRepository<ToDo, Integer> {

}
