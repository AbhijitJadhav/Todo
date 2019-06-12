package com.example.demo.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.model.Todo;
import com.example.demo.services.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	@Autowired
	public TodoService todoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class,new CustomDateEditor(format,false));		
	}
	
	
	@RequestMapping(value="/todos-list",method=RequestMethod.GET)
	public String getTodos(ModelMap model){
		String name = getLoggedInUserName(model);
		System.out.println(name);
		model.put("todos", todoService.retriveTodos(name));
		return "todos-list";	
	}
	
	
	@RequestMapping(value="/add-todo",method=RequestMethod.GET)
	public String showAddTodo(ModelMap model){
		//System.out.println(desc);
		//String name = getLoggedInUserName(model);
		model.put("todo", new Todo(0, getLoggedInUserName(model), "", new Date(), false));
		return "todo";
	}
	
	@RequestMapping(value="/add-todo",method=RequestMethod.POST)
	public String addtodo(ModelMap model,@Valid Todo todo,BindingResult result){
		
		if(result.hasErrors()) {
			return "todo";
		}
		todoService.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate());
		System.out.println(new Date());
		return "redirect:/todos-list";
	}


	private String getLoggedInUserName(ModelMap model) {
		return ( String ) model.get("name");
	}
	
	@RequestMapping(value="/delete-todo",method=RequestMethod.GET)
	public String deleteTodo(ModelMap model,@RequestParam Integer id) {
		 if(id == 1) {
			throw new RuntimeException();
		 }
		todoService.deleteTodo(id);
		return "redirect:/todos-list";
		
	}
	
	@RequestMapping(value="/update-todo",method=RequestMethod.GET)
	public String updateTodo(ModelMap model,@RequestParam Integer id) {
		Todo todo = todoService.retriveTodo(id);
		model.put("todo", todo);
		return "todo";
		
	}


	@RequestMapping(value="/update-todo",method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo,BindingResult result) {

		if(result.hasErrors()) {
			return "todo";
		}
		todo.setUser(getLoggedInUserName(model));
		todo.setIsDone(false);
		todoService.updateTodo(todo);
		return "redirect:/todos-list";
		
	}

}
