package cursors_enumeration_iterator_listiterator;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=1; i<=10;i++)
			al.add(i);
		
		System.out.println(al);
		Iterator<Integer> itr = al.iterator();
		while(itr.hasNext()){
			Integer I = itr.next();
			if(I%2==0)
				System.out.print(I+" ");
			else
				itr.remove(); //Here Odd Numbers will get removed
		}
		System.out.println();
		System.out.println(al); //Here Even numbers will print
	}

}
