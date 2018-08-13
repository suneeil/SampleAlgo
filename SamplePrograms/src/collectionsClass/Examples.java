package collectionsClass;

import java.util.ArrayList;
import java.util.Collections;

public class Examples {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(20);al.add(30);al.add(10);al.add(50);al.add(60);al.add(40);
		System.out.println("Actual AL: "+al);
		Collections.sort(al);
		System.out.println("After Sort: "+al);
		Collections.reverse(al);
		System.out.println("After Reverse: "+al);
		Collections.shuffle(al);
		System.out.println("After Shuffle: "+al);
		System.out.println("MAX: "+Collections.max(al));
		System.out.println("MIN: "+Collections.min(al));
	}

}
