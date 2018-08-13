package ArrayPrograms;

import java.util.Arrays;

public class ReverseAsentance {

	public static void main(String[] args) {
		
		revreseSentance("Trying to reverse String");
		System.out.println();
		strBuf("Trying to reverse String");
	}

	public static void  revreseSentance(String str){
		char[] c = str.toCharArray();
		int len = c.length;
		int start = 0;
		int end = len-1;
		char temp;
		while(start<end){
			temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			start ++;
			end --;
		}
		
		for(char ch : c)
			System.out.print(ch);
	}
	
	public static void strBuf(String str){
		StringBuffer sb = new StringBuffer(str);
		System.out.println(sb.reverse());
	}
	
}
