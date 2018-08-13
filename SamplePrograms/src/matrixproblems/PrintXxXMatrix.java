package matrixproblems;

import java.util.Random;

public class PrintXxXMatrix {

	public static void main(String[] args) {
		int matrixsize = 3; //need a 4X4 matrix
		Random rand = new Random();
		int prime = 0;
		int second = 0;
	/*	for(int i=0;i<20;i++)
			System.out.print(rand.nextInt(10)+" ");*/
		System.out.println();
		for(int row=0; row<matrixsize ; row++){
			for(int col=0; col<matrixsize; col++){
				int ran = rand.nextInt(10);
				System.out.print(ran + " ");
				if(col==row)
					prime = prime + ran;
				if((col+row)==(matrixsize-1)){
					second = second+ran;
					System.out.print("\n"+(col+row)+"=="+(matrixsize-1));
				}
			}
			System.out.println();
		}
		System.out.println("prime: " + prime);
		System.out.println("second: " + second);
	}
}
