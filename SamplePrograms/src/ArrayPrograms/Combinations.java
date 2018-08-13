package ArrayPrograms;

import java.util.Arrays;

public class Combinations {

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
		int pos = 0;
		for(int i=0; i<arr.length ; i++){
			//here swap 
			int temp = arr[i];
			arr[i] = arr[(arr.length-1)-i];
			arr[i+1] = temp;
			printArray(arr);
			
		}
	}
	
	
	public static void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
}
