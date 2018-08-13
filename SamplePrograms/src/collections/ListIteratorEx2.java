package collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorEx2 {
	 public static void main(String[] args) {
		    LinkedList<String> llist = new LinkedList<String>();
		    llist.add("A");
		    llist.add("B");
		    llist.add("C");
		    llist.add("D");
		    llist.add("E");
		    System.out.println("Elements of list = " + llist);
		    System.out.println("Size of list = " + llist.size());
		    ListIterator<String> litr = llist.listIterator();
		     while(litr.hasNext())
		       System.out.println(litr.next());
		    
		     /*System.out.println("Elements in reverse order : ");
		    System.out.println(litr.previous());
		    System.out.println(litr.previous());
		    System.out.println(litr.previous());
		    System.out.println(litr.previous());
		    System.out.println(litr.previous());
		    // For next line the previous( ) method will throws exception
		    System.out.println("\t-------------THROWS EXCEPTION------------- ");
		    System.out.println(litr.previous());*/
		     System.out.println("Reverse Order");
		     while(litr.hasPrevious())
		    	 System.out.println(litr.previous());
		  }
}
