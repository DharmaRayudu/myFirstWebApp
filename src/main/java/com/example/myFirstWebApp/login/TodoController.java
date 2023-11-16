package com.example.myFirstWebApp.login;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.myFirstWebApp.model.ToDo;
import com.example.myFirstWebApp.repository.TodoRepository;
import com.example.myFirstWebApp.service.ToDoService;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	private ToDoService doService;
	
	@RequestMapping(value = "todo", method = RequestMethod.GET)
	public String todoPage(ModelMap map) {
		String name =  getLogdInUser(map);
		System.out.println("What is the User name: "+ name);
		List<ToDo> toDos =  doService.findByUser(name);
		
		map.put("todos", toDos);
		return "todoListPage";
	}

	private String getLogdInUser(ModelMap map) {
//		return (String) map.getAttribute("name");
		Authentication action =  SecurityContextHolder.getContext().getAuthentication();
		return action.getName();
	}
	
	@RequestMapping(value = "add-todo", method = RequestMethod.GET)
	public String addTodo(ModelMap modelMap) {
		String name = (String)modelMap.get("name");
		ToDo toDo = new ToDo(0, name, "Default Desc", LocalDate.now().plusYears(1), false);
		modelMap.put("toDo", toDo);
		return "addTodo";
	}
	
	@RequestMapping(value = "add-todo", method = RequestMethod.POST)
	public String addNewTodo(ModelMap modelMap, @Valid ToDo toDo, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "addTodo";
		}
		
	 String userNmae = 	getLogdInUser(modelMap);
	 toDo.setName(userNmae);
		//doService.addTodo((String)modelMap.get("name"), toDo.getDescription(), toDo.getTargetDate(), true);
	 doService.addTodo(toDo);
		return "redirect:todo";
	}
	
	
	@RequestMapping(value = "delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id) {
		System.out.println("Deleted "+ id);
		doService.deleteTodo(id);
		return "redirect:todo";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String udpateTodo(@RequestParam int id, ModelMap map) {
		ToDo data =  doService.findById(id);
		map.put("toDo", data);
		return "addTodo";
	}
	
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String upDateTodo(ModelMap modelMap, @Valid ToDo toDo, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "addTodo";
		}
		
		System.out.println(toDo.getDescription());
		//doService.addTodo((String)modelMap.get("name"), toDo.getDescription(), LocalDate.now().plusYears(2), true);
		String username = (String)modelMap.get("name");
		toDo.setName(username);
		//todoService.updateTodo(todo);
		doService.updateTodo(toDo);
		return "redirect:todo"; // It's rediecting or calling /todo request
	}
}
