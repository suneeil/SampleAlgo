package setExamples;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSet_Ex {

	public static void main(String[] args) {
		SortedSet<String> sortedset = new TreeSet();
		sortedset.add("b");
		sortedset.add("c");
		sortedset.add("a");
		sortedset.add("f");
		sortedset.add("d");
		sortedset.add("a");
		sortedset.add("e");
		System.out.println(sortedset);
		System.out.println();
	}

}
