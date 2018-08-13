package com.org.RegularExpressions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile_ExtractMobile_WriteFile {

	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		
		
		Pattern p = Pattern.compile("(\\s+|([a-zA-Z])+|([^a-zA-Z0-9])+)+(0|91)?[789][0-9]{9}(\\s+|[.]+|([a-zA-Z])+|([^a-zA-Z0-9])+)+");
		Pattern p1 = Pattern.compile("\\d+");
		PrintWriter pr = new PrintWriter(path+"\\Output.txt");
		BufferedReader br = new BufferedReader(new FileReader(path+"\\Input.txt"));
		String line = br.readLine();
		
		while(line!=null){
				Matcher m = p.matcher(line);
				while(m.find()){
					m = p1.matcher(m.group());
						while(m.find()){
							System.out.println(m.group());
							pr.println(m.group());
						}				
				}
				line = br.readLine();
			}
		pr.close();pr.flush();br.close();

	}

}
