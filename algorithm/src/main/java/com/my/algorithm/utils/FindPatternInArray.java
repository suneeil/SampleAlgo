package com.my.algorithm.utils;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Arrays;

public class FindPatternInArray {

	public static void main(String[] args) {
		char[] arr = {'a','d','f','g','a','f','g','c','a','d','f','a','d','f','g','g'};
		System.out.println("Array Length"+ arr.length);
		char[] pattern = {'f','g'};
		System.out.println(getFirstMatch(arr, pattern));
		System.out.println(Arrays.toString(getAllMatch(arr, pattern)));
	}

	public static int getFirstMatch(char[] array, char[] pattern) {
		for(int aI =0; aI <= array.length-pattern.length;aI++) {
			for(int pI = 0 ; pI < pattern.length ; pI++) {
				//In the below if Condition array[aI+pI]
				//we are trying to increment the index in array without using the for loop 
				if(array[aI+pI] != pattern[pI])
					break;
				if(pI == pattern.length-1) 
					return aI;
			}
		}

		return -1;
	}
	
	

	private static int[] getAllMatch(char[] array, char[] pattern) {
		int[] foundArray = new int[array.length];
		Arrays.fill(foundArray, -1);
		int foundArrIndex = 0 ;
		for(int aI = 0; aI <= array.length-pattern.length; aI++) {
			for(int pI = 0 ; pI < pattern.length ; pI++) {
				//In the below if Condition array[aI+pI]
				//we are trying to increment the index in array without using the for loop 
				if(array[aI+pI] != pattern[pI])
					break;
				if(pI == pattern.length-1) 
					foundArray[foundArrIndex++] = aI;
			}
		}
		return foundArray;
	}	
	
}
