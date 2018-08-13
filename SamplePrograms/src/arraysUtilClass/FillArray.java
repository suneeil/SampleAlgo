package arraysUtilClass;

import java.util.Arrays;

public class FillArray {

	public static void main(String[] args) {
		int ar1[] = {4, 6, 1, 8, 3, 9, 7, 4, 2};
		
		Arrays.fill(ar1, 4, 8, 0);
		System.out.println(Arrays.toString(ar1));

		int ar2[] = {4, 6, 1, 8, 3, 9, 7, 4, 2};
		Arrays.fill(ar2, -1);
		System.out.println(Arrays.toString(ar2));
	}

}
