package com.pratice.MOCKITO.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements ToDoService{

	public List<String> retriveTodos(String user) {
		return Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
	}
	
}
