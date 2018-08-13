package ArrayPrograms;

import java.util.ArrayList;
import java.util.Arrays;

import arraysUtilClass.ArraysAsList;

public class FindLargestAndSmallest {

	public static void main(String[] args) {
		int[] arr = {-1,-2,-20,-30,-100,-99};
		findLS(arr);
		findLS2(arr);
	}

	
	public static void findLS(int[] arr){
		System.out.println(arr.length);
		if(arr.length<=0){
			System.out.println("Empty Array");
			return;
		}

		int small = Integer.MAX_VALUE;
		int large = Integer.MIN_VALUE;
		
		for(int n: arr){
			if(n>large)
				large = n;
			else if(n<small)
				small = n;
		}
		
		System.out.println("Large: " + large);
		System.out.println("Small: " + small);
	
	}
	
	
	public static void findLS2(int[] arr){
		Arrays.sort(arr);
		System.out.println("----------------------------------------");
		System.out.println("Largest: "+arr[arr.length-1]);
		System.out.println("Smallest: "+arr[0]);
		
	}
	
	
}
