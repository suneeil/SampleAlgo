package pratice;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class SumOfNNum {

	public static void main(String[] args) {
		System.out.println("Enter: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long arr[] = new long[n];
		
		long sum = 0;
		System.out.println("Entered: "+n);
		for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            sum = sum + arr[arr_i];
        }
		System.out.print(Arrays.toString(arr)+ ":"+sum);
	}

}
