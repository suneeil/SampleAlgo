package pratice;

import java.util.regex.Pattern;

public class CheckForNumInStr {
	public static void main(String[] args) {
		Pattern pattern1 = Pattern.compile(".*\\d.*");
		Pattern pattern2 = Pattern.compile(".*[0-9].*");
		System.out.println("Does the 123test contain num?: "+pattern1.matcher("123test").matches());
		System.out.println("Does the test123 contain num?: "+pattern1.matcher("test123").matches());
		System.out.println("Does the te123st contain num?: "+pattern1.matcher("te123st").matches());
		System.out.println("----------------------------------------");
		System.out.println("Does the 123test contain num?: "+pattern2.matcher("123test").matches());
		System.out.println("Does the test123 contain num?: "+pattern2.matcher("test123").matches());
		System.out.println("Does the te123st contain num?: "+pattern2.matcher("te123st").matches());		
	}
}