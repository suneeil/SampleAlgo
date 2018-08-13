package setExamples;

import java.util.LinkedHashSet;

public class linked_HasSetEx {

	public static void main(String[] args) {
		LinkedHashSet<String> linkedhasset = new LinkedHashSet<>();
		linkedhasset.add("a");
		linkedhasset.add("b");
		linkedhasset.add("c");
		linkedhasset.add("c");
		linkedhasset.add("d");
		linkedhasset.add(null);
		linkedhasset.add("b");
		linkedhasset.add("c");
		linkedhasset.add("a");
		linkedhasset.add("d");
		linkedhasset.add("z");
		linkedhasset.add("v");
		linkedhasset.add("r");
		linkedhasset.add("t");
		linkedhasset.add("y");
		linkedhasset.add("s");
		linkedhasset.add("p");
		linkedhasset.add("o");
		System.out.println(linkedhasset);

	}

}
