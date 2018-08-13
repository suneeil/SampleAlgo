package stringProg;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class IPAddressRegEx {

	public static void main(String[] args) {
		//System.out.println("Enter:\n");
		//Scanner in = new Scanner(System.in);
		 Pattern pattern;
		 Matcher matcher;
		String ipPattern = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
		try{
			pattern = Pattern.compile(ipPattern);
			matcher = pattern.matcher("00.12.123.123123.123");
			if(matcher.find())
				System.out.println("Matched");
			else
				System.out.println("No Match");
		}catch(PatternSyntaxException e){
			System.out.println("Invalid");
		}
		
		
	}

}
