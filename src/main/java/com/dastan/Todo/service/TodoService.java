package com.dastan.Todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dastan.Todo.model.ToDo;

@Service
public class TodoService {

	private static List<ToDo> tasks = new ArrayList<ToDo>();
	private static int todoCount = 3;
	
	static {
		
		tasks.add(new ToDo(1,"dastan","spring",new Date(), false));
		tasks.add(new ToDo(2,"dastan","mvc",new Date(), false));
		tasks.add(new ToDo(3,"dastan","h2",new Date(), false));
	}
	
	public List<ToDo> retrieveTodos(String user){
		List<ToDo> filteredTodos = new ArrayList<ToDo>();
		for(ToDo todo: tasks) {
			if(todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
	
	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		tasks.add(new ToDo(++todoCount, name, desc, targetDate, isDone));
	}
	
	public void deleteTodo(int id) {
		Iterator<ToDo> iterator = tasks.iterator();
		while(iterator.hasNext()) {
			ToDo todo = iterator.next();
			if(todo.getId() == id) {
				iterator.remove();
			}
		}
	}
}
