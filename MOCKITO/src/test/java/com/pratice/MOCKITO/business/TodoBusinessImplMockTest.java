package com.pratice.MOCKITO.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.pratice.MOCKITO.data.api.ToDoService;
import com.pratice.MOCKITO.data.api.TodoServiceStub;

public class TodoBusinessImplMockTest {

	@Test
	public void testRetriveTodosRelatedToSpring_usingAMock_List(){
		//Creating a Mock that a external Service provides,
		ToDoService todoServiceMock = mock(ToDoService.class);
		//Creating a List
		List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
		//Here we are creating a Mock that provides a list 
		when(todoServiceMock.retriveTodos("Dummy")).thenReturn(todos);
		//Test the Business Logic created in our team
		TodoBusinessImpl todoBusinessImp = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos =  todoBusinessImp.retriveTodosRealatedToSpring("Dummy");
		assertEquals(2,filteredTodos.size());
	}
	
	@Test
	public void testRetriveTodosRelatedToSpring_usingAMock_EmptyList(){
		//Creating a Mock that a external Service provides,
		ToDoService todoServiceMock = mock(ToDoService.class);
		//Creating a Empty List
		List<String> todos = Arrays.asList();
		//Here we are creating a Mock that provides a list 
		when(todoServiceMock.retriveTodos("Dummy")).thenReturn(todos);
		//Test the Business Logic created in our team
		TodoBusinessImpl todoBusinessImp = new TodoBusinessImpl(todoServiceMock);
		List<String> filteredTodos =  todoBusinessImp.retriveTodosRealatedToSpring("Dummy");
		assertEquals(0,filteredTodos.size());
	}
	
}
