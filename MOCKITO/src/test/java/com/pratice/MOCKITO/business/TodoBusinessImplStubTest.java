package com.pratice.MOCKITO.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.pratice.MOCKITO.data.api.ToDoService;
import com.pratice.MOCKITO.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetriveTodosRelatedToSpring_usingAStub(){
		ToDoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImp = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos =  todoBusinessImp.retriveTodosRealatedToSpring("Dummy");
		assertEquals(2,filteredTodos.size());
		
	}
	
}
