package comparableAndcomporator;

import java.util.TreeSet;

public class ComporatorWithCustomSorting {

	public static void main(String[] args) {
		TreeSet<Integer> t = new TreeSet<Integer>(new CustomSort());
		
		t.add(1);
		t.add(3);
		t.add(2);
		t.add(5);
		t.add(6);
		t.add(4);
		t.add(7);
		System.out.println(t);

		TreeSet<Object> strTree = new TreeSet<Object>(new CustomStringSort());
		
		strTree.add("Sam");
		strTree.add("Sun");
		strTree.add("Abhi");
		strTree.add("Bob");
		strTree.add("Ron");
		strTree.add("Dave");
		
		System.out.println(strTree);
	}

}
