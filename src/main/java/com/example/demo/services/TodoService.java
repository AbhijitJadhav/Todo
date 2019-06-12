package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todosCount = 3;
	
	static {
		todos.add(new Todo(1, "abhijit", "learn spring", new Date(), false));
		todos.add(new Todo(2, "abhijit", "learn java", new Date(), false));
		todos.add(new Todo(3, "abhijit", "learn java8", new Date(), false));
	}
	
	public List<Todo> retriveTodos(String user){
		List<Todo> userTodos = new ArrayList<>();
		for (Todo todo : todos) {
			if(todo.getUser().equals(user))
				userTodos.add(todo);
		}
		return userTodos;
	}
	
	public void addTodo(String name,String desc,Date targetDate) {
		todos.add(new Todo(++todosCount, name, desc, targetDate, false));
	}
	
	public void deleteTodo(Integer id) {
		Iterator<Todo> iterator = todos.iterator();
		while(iterator.hasNext()) {
			Todo todo = iterator.next();
			if(todo.getId() == id)
				iterator.remove();
		}
	}
	
	public Todo retriveTodo(Integer id) {
		Iterator<Todo> iterator = todos.iterator();
		while(iterator.hasNext()) {
			Todo todo = iterator.next();
			if(todo.getId() == id)
				return todo;
		}
		return null;
	}
	
	public void updateTodo(Todo todo) {
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
