package ArrayPrograms;

import java.util.Arrays;
import java.util.Spliterator;

public class Arrays_Spliterator {

	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,7,8};
		Spliterator<Integer> sp = Arrays.spliterator(arr);
		sp.forEachRemaining(System.out::println);

	}

}
