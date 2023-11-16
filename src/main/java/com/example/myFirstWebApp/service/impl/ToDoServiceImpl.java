package com.example.myFirstWebApp.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myFirstWebApp.model.ToDo;
import com.example.myFirstWebApp.repository.TodoRepository;
import com.example.myFirstWebApp.service.ToDoService;

import jakarta.validation.Valid;

@Service
public class ToDoServiceImpl implements ToDoService {
	
	@Autowired
	private TodoRepository repository;
	private static List<ToDo> dos = new ArrayList<ToDo>();
	
	private static int countId = 0;
	static {
		dos.add(new ToDo(++countId, "Java", "Learning", LocalDate.now().plusYears(1), true));
		dos.add(new ToDo(++countId, "Spring Boot", "Learning", LocalDate.now().plusYears(1), false));
		dos.add(new ToDo(++countId, "Full Stack", "Learning", LocalDate.now().plusYears(1), false));
	}

	@Override
	public List<ToDo> findByUser(String name) {
		return repository.findAll();
		
	}

	@Override
	public void addTodo(ToDo toDo) {
		
		repository.save(toDo);
		  //dos.add(new ToDo(++countId, name, description, targetDate, done));
	}

	@Override
	public void deleteTodo(int id) {
		
		//Predicate<? super ToDo> predicate = todo -> todo.getId() == id;
		//dos.removeIf(predicate);
		repository.deleteById(id);
		
	}

//	@Override
//	public void updateTodo(int id) {
//		
//		ToDo do1 =  dos.get(id);
//		dos.add(new ToDo(id, do1.getName(), do1.getDescription(), do1.getTargetDate(), do1.isDone()));
//		
//	}

	@Override
	public ToDo findById(int id) {
		
	   //return dos.stream().filter(ob-> ob.getId()==id).findFirst().get();
		Optional<ToDo> data  =  repository.findById(id);
		
		
		return data.get();
		
	}

	@Override
	public void updateTodo(ToDo toDo) {
		// TODO Auto-generated method stub
		
		repository.save(toDo);
		
		
	}

}
