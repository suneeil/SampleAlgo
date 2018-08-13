package com.my.algorithm.utils;

public class FindMaxSumInSubArray {

	public static void main(String[] args) {
		int[] arr = {4,-2, -2, 2 , 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2};
		maxSumSubArr(arr);
	}

	
	public static void maxSumSubArr(int[] arr) {
		int max_so_far = 0;
		int max_end_here = 0;
		int start = 0, end = 0, searchStartOfNextSubArr = 0;
		
		for(int i = 0; i < arr.length; i++) {
			
			max_end_here = max_end_here + arr[i];
			if(max_end_here > max_so_far ) {
				max_so_far = max_end_here;
				start = searchStartOfNextSubArr;
				end = i;
			}
			if(max_end_here < 0) {
				max_end_here = 0;
				searchStartOfNextSubArr = i + 1; //searchStartOfNextSubArris start of Count as we know the 
				//max_end_here is less than zero we move the start from next index so incrementing searchStartOfNextSubArr
			}
		}
		System.out.println("Max :" + max_so_far);
		System.out.println(start + " " + end);
	}
	
	

	
}
