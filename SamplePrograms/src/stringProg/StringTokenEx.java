package stringProg;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokenEx {

	public static void main(String[] args) {
		String str = "He is a very very good boy, isn't he?";
	
		System.out.println("==========================");
		 String delim = "[ !,?._'@\"'^&*()#]+";
		// String delim = " ,'?";
		StringTokenizer stk = new StringTokenizer(str,delim);
		System.out.println(stk.countTokens());
		while(stk.hasMoreTokens()){
			System.out.print(stk.nextToken()+"/");
		}
	}

}
