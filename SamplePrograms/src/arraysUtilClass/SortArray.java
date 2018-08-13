package arraysUtilClass;

import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {
		int[] arr = {7,3,4,5,2,1,6,5};
		
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, 0, 5);
		System.out.println(Arrays.toString(arr));
		
		
		
	}

}
