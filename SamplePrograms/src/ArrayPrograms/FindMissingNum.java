package ArrayPrograms;

import java.util.Arrays;

public class FindMissingNum {

	public static void main(String[] args) {
		int[] arr = {2,3,1,5,6};
		findMissing(arr, arr.length+1);
		
	}

	
	public static void findMissing(int[] arr, int actTotArrEle){
		Arrays.sort(arr);
		int tot = actTotArrEle*(actTotArrEle+1)/2;
		int arrTot=0;
		for(int n : arr){
			arrTot = arrTot+n;
		}
		System.out.println("Missing Number: "+ (tot-arrTot));
	}
}
