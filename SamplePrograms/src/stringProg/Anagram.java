package stringProg;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		System.out.println("Enter");
		 Scanner scan = new Scanner(System.in);
	        String a = scan.next();
	        String b = scan.next();
	        scan.close();
	        boolean ret = isAnagram(a, b);
	        System.out.println("Result: "+ret);
	        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}

	
		public static boolean isAnagram(String a, String b){
			
			char[] str1 = a.toLowerCase().toCharArray();
			char[] str2 = b.toLowerCase().toCharArray();
			Arrays.sort(str1);
			Arrays.sort(str2);
			System.out.println(str1);
			System.out.println(str2);
			
			return Arrays.equals(str1, str2);
		}
}
