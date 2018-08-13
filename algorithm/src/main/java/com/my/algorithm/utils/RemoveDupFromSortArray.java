package com.my.algorithm.utils;

import java.util.Arrays;

public class RemoveDupFromSortArray {

	public static void main(String[] args) {
		int[] arr = {1,2,2,3,3,4,4,4,5,5,6};
		removeDupeEle(arr);
		removeDupeEleSameArr(arr);
	}

	/**
	 * Using Extra Array
	 * @param arr
	 */
	public static void removeDupeEle(int[] arr) {
		int len = arr.length;
		int[] uniqueArr = new int[arr.length];
		int j = 0;
		for(int i = 0; i < len-1; i++) {
			if(arr[i] != arr[i+1]) {
				uniqueArr[j] = arr[i];
					j++;
			}
		}
		uniqueArr[j] = arr[len-1];
		System.out.println(Arrays.toString(uniqueArr));
	}
	
	public static void removeDupeEleSameArr(int[] arr) {
		int len = arr.length;
		
		int j = 0;
		for(int i = 0; i < len-1; i++) {
			if(arr[i] != arr[i+1]) {
				arr[j] = arr[i];
					j++;
			}
		}
		arr[j] = arr[len-1];
		Arrays.fill(arr, j+1, len, 0);
		System.out.println(Arrays.toString(arr));
	}
	
}
