package stringProg;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class BigSmallStr {

	public static void main(String[] args) {
		System.out.println("Enter: ");
		Scanner in = new Scanner(System.in);
		
		String str = in.next();
		int splitBy = in.nextInt();
		int strLen = str.length()-1;
		
		
		TreeSet<String> arr = new TreeSet<String>();
		
		for(int i=0; i<str.length()-(splitBy-1); i++){
			arr.add(str.substring(i, i+splitBy));
		}
		
		System.out.println(arr.first());
		System.out.println(arr.last());
	}

	
	
	
}
