package com.org.RegularExpressions;

import java.util.regex.Pattern;

public class PatternSplit {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("[.]");
		patternSplit("www.gmail.com", p);
		strSplit("www.gmail.com", "");
	}
	
	public static void strSplit(String str, String pattern){
		String[] strArr = str.split(pattern);
		for(String s : strArr){
			System.out.println(s);
		}
	}
	
	public static void patternSplit(String str, Pattern pat){
		String[] strArr = pat.split(str);
		for(String s : strArr){
			System.out.println(s);
		}
	}
	
}
