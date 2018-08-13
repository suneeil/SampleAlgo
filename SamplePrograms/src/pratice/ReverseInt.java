package pratice;

import java.util.Arrays;

public class ReverseInt {

	public static void main(String[] args) {
		int n = 123;
		int rev = 0, last = 0;
		
		while(n>=1){
			last = n%10;
			rev = rev *10 + last;
			n = n/10;
		}
		System.out.println(rev);
		strRevfun(123);
	}

	public static void strRevfun(int num){
		System.out.println("Using StringBffer ");
		StringBuffer str = new StringBuffer(Integer.toString(num));
		StringBuffer rev = str.reverse();
	
		System.out.println(rev);
	
		Integer revNum = Integer.parseInt(rev.toString());
		System.out.println(revNum);
		Integer revNum1 = Integer.valueOf(rev.toString());
		System.out.println(revNum1);
	}
	
	
}
