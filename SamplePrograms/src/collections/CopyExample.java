package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyExample {

	public static void main(String args[]) {

	      // create two lists    
	      List<String> srclst = new ArrayList<String>();
	      List<String> destlst = new ArrayList<String>();

	      // populate two lists
	      srclst.add("Java");
	      srclst.add("is");
	      srclst.add("best");

	      destlst.add("C++");
	      destlst.add("is");
	      destlst.add("older");

	      // copy into dest list
	      Collections.copy(destlst, srclst);            

	      System.out.println("Value of source list: "+srclst);
	      System.out.println("Value of destination list: "+destlst);
	   }    
}
