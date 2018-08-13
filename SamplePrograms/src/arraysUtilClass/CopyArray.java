package arraysUtilClass;

import java.util.Arrays;

public class CopyArray {

	public static void main(String[] args) {
		int ar[] = {4, 6, 1, 8, 3, 9, 7, 4, 2};
		
		//Copy the whole Array
		int[] copy = Arrays.copyOf(ar, ar.length);
		System.out.println("Copied Array: \n"+ Arrays.toString(copy));
		
		int[] rangeCopy = Arrays.copyOfRange(copy, 0, 4);
		System.out.println("Range Copy:\n"+Arrays.toString(rangeCopy));

	}

}
