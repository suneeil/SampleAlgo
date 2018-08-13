package com.org.RegularExpressions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMobileNumber {

	public static void main(String[] args) throws IOException {
		Pattern p = Pattern.compile("(0|91)?[7-9][0-9]{9}");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a mobile number:");
		
		String mobile = sc.next();
		
		Matcher m = p.matcher(mobile);
		if(m.find()&& m.group().equals(mobile)){
			System.out.println("Valid Mobile Number");
		}else{
			System.out.println("Invalid Mobile Number");
		}

	}

}
