package com.pratice.MOCKITO.business;

import java.util.ArrayList;
import java.util.List;

import com.pratice.MOCKITO.data.api.ToDoService;

//The class TodoBusinessImpl is System under test
public class TodoBusinessImpl {

	private ToDoService todoService;

	public TodoBusinessImpl(ToDoService todoService) {
		this.todoService = todoService;
	}

	public List<String> retriveTodosRealatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<String>();
		
		List<String> todos = todoService.retriveTodos(user);
		System.out.println("TODOS: "+todos);
		for(String todo : todos){
			if(todo.contains("Spring")){
				filteredTodos.add(todo);
			}
		}
		System.out.println("Added filteredTodos: "+filteredTodos);
		return filteredTodos;
		
	}
	
	
}
