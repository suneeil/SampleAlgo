package stringProg;

import java.util.StringTokenizer;

public class FindOccuranceOfChar {

	public static void main(String[] args) {
		String str = "who are you";
		findOccu_1(str, 'y');
		char[] charr = str.toCharArray();
		
	}

	public static void findOccu_1(String str, char ch){
		int count = 0;
		while(str.indexOf(ch)>=0){
			count ++;
			str = str.substring(str.indexOf(ch)+1);
		}
		System.out.println(count);
	}
	
}
