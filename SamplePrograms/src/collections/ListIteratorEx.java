package collections;

import java.util.*;
public class ListIteratorEx {

	public static void main(String[] args) {
			ArrayList<Integer> arrLi = new ArrayList<Integer>();
			arrLi.add(10);
			arrLi.add(20);
			arrLi.add(30);
			arrLi.add(40);
			arrLi.add(50);
			arrLi.add(60);
			System.out.println(arrLi);
			ListIterator<Integer> listItr = arrLi.listIterator();
			
			while(listItr.hasNext()){
				Integer val = listItr.next();

					if(val == 20){
						listItr.remove();
					}else if(val == 30){
						listItr.add(35);
					}else if (val == 50){
						listItr.set(55);
					}
				}
			System.out.println(arrLi);
	}
	

}
