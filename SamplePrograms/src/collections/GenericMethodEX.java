package collections;

import java.util.ArrayList;
import java.util.Set;

public class GenericMethodEX {

	public static void main(String[] args) {
		returnAnyType("Sunil");
		returnAnyType(123);
		returnAnyType(1.2);
		
	}

	public static <T> T returnAnyType(T val){
		
		System.out.println(val + " is of " + val.getClass().getSimpleName() + " class");
		return val;
		
	}
	
	
}
