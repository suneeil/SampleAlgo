package queueEx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQeueEx {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		System.out.println(pq.peek());
		pq.offer(1);
		pq.offer(2);
		pq.offer(3);
		pq.offer(4);
		pq.offer(5);
		pq.offer(5);
		pq.offer(5);
		pq.offer(5);
		pq.offer(5);
		
		
		Iterator<Integer> it = pq.iterator();
		System.out.println(pq);
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
	}

}
