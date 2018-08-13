package ArrayPrograms;

import java.util.Arrays;

public class MergeArray {

	public static void main(String[] args) {
		int[] arr1 = {2,3,4,5};
		int[] arr2 = {6,8,7,9,10};
		mergeArr(arr1, arr2);
	}
	
	public static void mergeArr(int[] Larr, int[] Rarr){
		int LarrLen = Larr.length;
		int RarrLen = Rarr.length;
		int newLength = LarrLen+RarrLen;
		int[] newArr = new int[newLength];
		int IL=0,IR=0,IK=0;
		
		while(IL < LarrLen){
			newArr[IK] = Larr[IL];
			IL++; IK++;
		}
		System.out.println("IK"+IK);
		while(IR < RarrLen){
			newArr[IK] = Rarr[IR];
			IR++; IK++;
		}
		System.out.println(Arrays.toString(newArr));
	}

	
	
	
}
