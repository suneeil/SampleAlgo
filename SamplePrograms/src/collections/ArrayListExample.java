package collections;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

//import javax.smartcardio.ATR;

public class ArrayListExample {

	public enum DefaultName{Raja, Ram, Mohan, Roy}
	
	public static void main(String[] args) {
		
		DefaultName name = null;
		System.out.println(name.values().length);
		System.out.println("-------------------------------");
		for(DefaultName n : name.values())
			System.out.println(""+n);
		System.out.println("-------------------------------"); 
		// create array list object       
		   ArrayList<String> al1 = new ArrayList<String>();
		   String[] strArr = new String[10];
		   strArr[0]="E";
		  ArrayList<String> arrToAL = new ArrayList<>(Arrays.asList(strArr));
		  arrToAL.add("A");
		  arrToAL.add("B");
		  arrToAL.add("C");
		  arrToAL.add("D");
		  
		  int[] num = {1,2,3,4};
		  System.out.println("3 is at index: "+Arrays.binarySearch(num, 3));
		  Character[] chArr = {'a','b','e','h','i','k','l','d','n','o','w','s','q','g'};
		 ArrayList<Character> chALI = new ArrayList<>(Arrays.asList(chArr));
		 System.out.println("w is at: "+Arrays.binarySearch(chArr, 'w'));
		 
		 Collections.sort(chALI);
		 System.out.println(chALI);
		 //Collections.sort(chArr);
		 System.out.println("w is at: "+chALI.indexOf('w'));
		 
		  
		  System.out.println(arrToAL.toString());
		   // populate the list
		   al1.add("A");
		   al1.add("B");
		   al1.add("C");  
		 
		   
		   
		   
		   ArrayList<String> al2 = new ArrayList<String>();
		   al2.add("A");
		   al2.add("B");
		   al2.add("C");
		   al2.add("D");
		   
		  System.out.println(al2.removeAll(al1));
		  System.out.println(al2);
		  
		  arrToAL.removeAll(al1);
		  System.out.println(arrToAL);
		  
		  Vector<String> v = new Vector<String>();
		  Iterator<String> it = v.iterator(); 

		  System.out.println("------------------------------");
		  ArrayList<String> arrl = new ArrayList<String>();
		  //adding elements to the end
	        arrl.add("First");
	        arrl.add("Second");
	        arrl.add("Third");
	        arrl.add("Random");
	        System.out.println("Actual ArrayList:"+arrl);
	        ArrayList<String> copy = (ArrayList<String>) arrl.clone();
	        copy.add("AddedByCopy");
	        System.out.println("Cloned ArrayList:"+copy);
		
	        System.out.println("==============================================");
	        printAnything("Sunil");
	        printAnything(3);
	        printAnything(al1);
	        printAnything(1.2);
	        printAnything(chArr);
	        printAnything('c');
	        
	        System.out.println("==============================================");
	}
	
	public static <T> void printAnything(T anyType){
		
		System.out.println("Printing: "+anyType+" of type : " + anyType.getClass().getSimpleName());
		
	}
	
	
}



