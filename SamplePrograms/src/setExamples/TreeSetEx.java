package setExamples;

import java.util.TreeSet;

public class TreeSetEx {

	public static void main(String[] args) {
		TreeSet<Integer> treeset = new TreeSet<>();
		treeset.add(100);
		treeset.add(106);
		treeset.add(108);
		treeset.add(111);
		treeset.add(113);
		treeset.add(115);
		treeset.add(119);

		System.out.println(treeset);
		/*System.out.println("First Element: "+treeset.first());
		System.out.println("Last Element: "+treeset.last());
		System.out.println("Lesser than 113: "+treeset.headSet(113));
		System.out.println("Greater than 108: "+treeset.tailSet(108));
		System.out.println("Sube set of 108 and 116: " + treeset.subSet(108, 116));
			
		treeset.clear();
		System.out.println("After Clearing: "+treeset);
		//To check the Natural Sorting Order
		TreeSet<Character> treesetChar = new TreeSet<Character>();
		treesetChar.add('a');
		treesetChar.add('D');
		treesetChar.add('B');
		treesetChar.add('D');
		treesetChar.add('A');
		treesetChar.add('C');
		System.out.println("Natural Sorting Order: "+treesetChar);*/
	}

}
