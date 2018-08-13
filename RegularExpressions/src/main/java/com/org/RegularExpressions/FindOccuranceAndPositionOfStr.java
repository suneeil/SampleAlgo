package com.org.RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindOccuranceAndPositionOfStr {
	public static void main(String[] args) {
		int count = 0;
		Pattern p = Pattern.compile("ab");
		//Note:
		//compile method is static method 
		//By using class name if we are calling a method that method returns the same class object such are called as Static factory methods
		Matcher m = p.matcher("ababbaba");
		//Note: compile method is available in Pattern class and matcher method is also present in Pattern class.
		while(m.find()){
			count ++;
			System.out.println(m.start()+"--"+m.end()+"--"+m.group());
		}
		System.out.println("Number of Occurences: " + count);	
	}
}
