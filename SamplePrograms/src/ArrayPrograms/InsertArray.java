package ArrayPrograms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertArray {

	public static void main(String[] args) {
		Integer[] arr = {1,2,4,5};
		
		int index = 3;
		Integer element = 9;
		System.out.println(Arrays.toString(arr));
		LinkedList<Integer> li = new LinkedList<>(Arrays.asList(arr));
		System.out.println(li);
		li.add(index, element);
		System.out.println(li);
		Integer[] newArr = li.toArray(new Integer[li.size()]);
		System.out.println(Arrays.toString(newArr));
		

	}

}
