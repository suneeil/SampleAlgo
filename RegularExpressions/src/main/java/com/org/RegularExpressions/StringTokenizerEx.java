package com.org.RegularExpressions;

import java.util.StringTokenizer;

public class StringTokenizerEx {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("10-12-1981", "-");
			while(st.hasMoreTokens()){
				System.out.println(st.nextToken());
			}
	}
}
