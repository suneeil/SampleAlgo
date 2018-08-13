package ArrayPrograms;

import java.util.Arrays;
import java.util.LinkedList;

public class ConvertListToArray {

	public static void main(String[] args) {
		
		LinkedList<Integer> li = new LinkedList<>();
		li.add(10);
		li.add(20);
		li.add(30);
		
		//Converting List to Array
		Integer[] newArr = li.toArray(new Integer[li.size()]);
		System.out.println(Arrays.toString(newArr));
	}

}
