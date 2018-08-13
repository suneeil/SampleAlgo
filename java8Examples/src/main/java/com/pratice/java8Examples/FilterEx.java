package com.pratice.java8Examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FilterEx {

	public static void main(String[] args) {
		  List<String> lines = Arrays.asList("spring", "node", "mkyong");
		  String str = "mkyong";
		 List<Object> result = lines.stream().filter(line -> !str.equals(line)).collect(Collectors.toList());
		 result.forEach(System.out::println);
		 
		 
		 String found = lines.stream().filter(line -> str.equals("sunil")).findAny().orElse("Not Found");
		 System.out.println("Found: "+found);
		
		 
	}

	
}
