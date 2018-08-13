package cursors_enumeration_iterator_listiterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class ListIteratorEx {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=1;i<=10;i++)
			al.add(i);
		
		Collections.shuffle(al);
		
		ListIterator<Integer> itr = al.listIterator();
		while(itr.hasNext()){
			Integer I = itr.next();
			System.out.print(I+" ");
			
		}
		System.out.println("\n--------------");
		
//		while(itr.hasPrevious()){
//			System.out.print(itr.previous()+" ");
//		}

	}

}
