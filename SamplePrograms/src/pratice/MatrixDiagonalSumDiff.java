package pratice;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixDiagonalSumDiff {

	public static void main(String[] args) {
		System.out.println("Enter");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println("Entered: "+ n + " Size Array");
		int a[][] = new int[n][n];
		int sumA=0,sumB=0;

		for(int a_i=0; a_i < n; a_i++){
			for(int a_j=0; a_j < n; a_j++){
				a[a_i][a_j] = in.nextInt();

			}
		}
		System.out.println(Arrays.toString(a[0]));
		System.out.println(Arrays.toString(a[1]));



		int sum = 0;
		/* for(int row=0; row<n ; row++){
        	for(int col=0+row;col<n;col+=n){
        		System.out.println(a[row][col]);

        	}

        }*/
		for(int row=0; row<n ; row++){
			for(int col=n-1;col>0;col-=n){
				System.out.println(a[row][col]);

			}

		}


	}

}
