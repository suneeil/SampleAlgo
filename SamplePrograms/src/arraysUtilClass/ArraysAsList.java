package arraysUtilClass;

import java.util.Arrays;
import java.util.List;

public class ArraysAsList {

	public static void main(String[] args) {
		Integer ar[] = {4, 6, 1, 8, 3, 9, 7, 4, 2};
		
		List<Integer> li = Arrays.asList(ar);
		System.out.println(li);
		System.out.println(Boolean.valueOf("true"));
		System.out.println(Boolean.valueOf(true));
	}

}
