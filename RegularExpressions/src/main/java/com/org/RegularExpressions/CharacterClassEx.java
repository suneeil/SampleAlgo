package com.org.RegularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClassEx {
	public static void main(String[] args) {
		int count = 0;
		Pattern p = Pattern.compile(".");
		Matcher m = p.matcher("a7b@ 2D#9");
		while(m.find()){count ++;
			System.out.println(m.start()+"--"+m.group());}
		System.out.println("Count: " + count);	
	}
}


