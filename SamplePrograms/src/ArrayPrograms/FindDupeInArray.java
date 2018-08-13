package ArrayPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FindDupeInArray {

	public static void main(String[] args) {
		Integer[] arr = {1,1,2,3,2,3};
		int[] arr1 = {2,3,1,5,6,6,1,2,2,4,6,7};
		findDupe(arr);
		//dupe_Set(arr);
	}

	public static void findDupe(Integer[] arr){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(Integer n : arr){
			if(map.containsKey(n)){
				map.put(n, map.get(n)+1);
			}else
				map.put(n,1);
		}
		System.out.println(map);

		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		Iterator<Entry<Integer,Integer>> itr = entrySet.iterator();
		Entry<Integer,Integer> entry;
		while(itr.hasNext()){
			entry = itr.next();
			if(entry.getValue()>1){
				System.out.println(entry.getKey()+": "+entry.getValue() );
			}
		}

	}

	public static void dupe_Set(Integer[] arr){
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(arr));
		HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
		al.removeAll(set); 
		System.out.println(set);
	}
	
}
