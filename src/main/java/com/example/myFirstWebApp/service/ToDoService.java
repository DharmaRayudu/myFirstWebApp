package com.example.myFirstWebApp.service;

import java.util.List;

import com.example.myFirstWebApp.model.ToDo;

public interface ToDoService {
	  
	  List<ToDo> findByUser(String name);
	  
	  void addTodo(ToDo toDo);
	  
	  void deleteTodo(int id);
	  void updateTodo(ToDo toDo);

	ToDo findById(int id);
	

}
