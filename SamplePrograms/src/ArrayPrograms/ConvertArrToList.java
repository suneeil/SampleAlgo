package ArrayPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ConvertArrToList {

	public static void main(String[] args) {
		Integer[] arr = {3,2,4,6,7,8,1,98,9};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		//Convert Array to List
		List<Integer> li = Arrays.asList(arr);
		System.out.println("List: "+ li);
		ListIterator<Integer> itr = li.listIterator();
		System.out.println(itr.hasNext());
		
	}

}
