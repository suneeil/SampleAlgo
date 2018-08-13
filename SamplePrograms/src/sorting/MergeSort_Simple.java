package sorting;

import java.util.Arrays;

public class MergeSort_Simple {

	static int[] arr = {50,90,40,-100,10,70,80,20,60,30};
	
	public static void main(String[] args) {
		sortArr(arr);
		System.out.println("Array: "+Arrays.toString(arr));
		
	}

	private static void sortArr(int[] arr) {
		if(arr.length<2)
			return;
		//Create Left Array and Right Array
		int mid = (arr.length)/2;
		int[] larr = new int[mid];
		int[] rarr = new int[arr.length-mid];
		for(int i=0;i<larr.length;i++){
			larr[i] = arr[i];
		}
		for(int i=mid;i<arr.length;i++){
			rarr[i-mid] = arr[i]; 
		}
		
		//System.out.println("Left: "+Arrays.toString(larr));
		//System.out.println("Right: "+Arrays.toString(rarr));
		
		sortArr(larr);
		sortArr(rarr);
		mergeArr(arr,larr,rarr);
		
	}

	private static void mergeArr(int[] arr, int[] larr, int[] rarr) {
		int len_larr = larr.length;
		int len_rarr = rarr.length;
		int i=0, j=0, k=0;
		
		while(i<len_larr && j<len_rarr){
			if(larr[i]<rarr[j]){
				arr[k] = larr[i];
				i++;
			}else{
				arr[k] = rarr[j];
				j++;
			}
			k++;
		}
		
		while(i<len_larr){
			arr[k] = larr[i];
			i++; k++;
		}
		while(j<len_rarr){
			arr[k] = rarr[j];
			j++; k++;
		}
		
	}
}
