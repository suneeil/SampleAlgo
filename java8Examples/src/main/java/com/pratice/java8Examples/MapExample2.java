package com.pratice.java8Examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.print.DocFlavor.STRING;

public class MapExample2 {

	public static void main(String[] args) {
		List<String> alpha = Arrays.asList("a", "b", "c", "d");
		System.out.println(alpha);
		List<String> upperAlpha = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upperAlpha);
		
		//Example 2
		List<Integer> num = Arrays.asList(1,2,3,4,5);
		System.out.println("Before: "+num);
		List<Integer> num2  = num.stream().map(m -> m*2).collect(Collectors.toList());
		System.out.println("After: "+num2);
		
		
		

	}

}
