package ArrayPrograms;

import java.util.Arrays;

public class CheckNuminArr {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		
		System.out.println("Iterative Binary Search: "+Arrays.binarySearch(arr, 2));
		System.out.println("----------------");
		System.out.println("Found at: "+myBinarySearch(arr, 9));
		System.out.println("----------------");
		System.out.println("Recursive Binary Search: "+recurSearch(arr, 0, arr.length-1, 2));
	}

	
	private static int myBinarySearch(int[] arr, int key){
		int low=0,high=arr.length-1;
		int mid=0;
		while(low<=high){
			mid = (low+high)/2;
			if(key==arr[mid])
				return mid;
			else if(key<arr[mid]){
				high = mid-1;
			}else if(key>arr[mid]){
				low = mid+1;
			}
		}
		return -1;
	}
	
	private static int recurSearch(int[] arr, int low, int high, int key){
		int mid = (low+high)/2;
		if(key==arr[mid])
			return mid;
		else if(key<arr[mid]){
			return recurSearch(arr, low, mid-1, key);
		}else if(key>arr[mid]){
			return recurSearch(arr, mid+1, high, key);
		}
		return -1;
	}

}
