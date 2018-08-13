package stringProg;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

	public static void main(String[] args) {
		String[] words = {"w:/a\\bc::/12\\xyz"};
		int[] results = findAdorable(words);
		System.out.println(Arrays.toString(results));
	}

	private static int[] findAdorable(String[] words) {
		int[] results = new int[words.length];
		int count = 0;
		
		for(int i = 0; i < words.length; i++) {
			count = 0;
			for(int j = 0; j < words[i].length(); j++) {
				if(isAdorable(words[i].substring(j, words[i].length()))) {
					count++;
				}
			}
			for(int j = words[i].length() - 1; j >= 0; j--) {
				if(isAdorable(words[i].substring(0, j))) {
					count++;
				}
			}
			results[i] = count;
		}
		return results;
	}
	
	private static boolean isAdorable(String str) {
		System.out.println(str);
		Pattern p = Pattern.compile("^[a-z][a-z0-9:]*/[a-z0-9]+\\\\[a-z]*$");
		Matcher matcher = p.matcher(str);
		if(matcher.matches()) {
			System.out.println("YES");
			return true;
		}
		return false;
	}
}
