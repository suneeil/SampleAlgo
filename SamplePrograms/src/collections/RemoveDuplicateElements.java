package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class RemoveDuplicateElements {

	public static void main(String[] args) {
		Integer[] arr = {1,2,2,3,3,3,4,4};
		removeDupeEle(arr);
	}
	
	
	public static void removeDupeEle(Integer[] arr) {
		int len = (arr.length);
		List<Integer> li1 = new ArrayList<>(Arrays.asList(arr));
		List<Integer> li2 = new ArrayList<>(len);
		Set<Integer> s = new HashSet<>();		
		s.addAll(li1);
		/*li1.forEach(System.out::print);
		System.out.println();
		s.forEach(System.out::print);
		System.out.println();
		s.forEach(it -> System.out.print(it));*/
		
		System.out.println("--"+ li1);
		System.out.println("--"+ s);
	}

}
