package stringProg;

import java.util.Scanner;

public class Palandrome {

	public static void main(String[] args) {
		System.out.println("Enter");
		 Scanner in = new Scanner(System.in);
		 String A = in.next().toLowerCase();
		 
	
			 
		String firstPart = "";
		String secondPart="";
		 
		
		 
		 int mid = A.length()/2;
		 	if(A.length()%2==0){//dividing the string in two equal halves
		 	/*	System.out.println("Divide the String two halves");
		 		System.out.println(A.substring(0, mid));
		 		System.out.println(A.substring(mid, A.length()));*/
		 		firstPart = A.substring(0, mid);
		 		secondPart = A.substring(mid, A.length());
		 	}else{//Here we are keeping the middle string and dividing the dividing the string in two halves 
		 		/*System.out.println("Have the middle character and then swap");
		 		System.out.println(A.substring(0, mid));
		 		System.out.println(A.substring(mid+1, A.length()));*/
		 		firstPart = A.substring(0, mid);
		 		secondPart = A.substring(mid+1, A.length());
		 	}
		 
		 	int start = 0;
		 	int end = secondPart.length()-1;
		 	char[] chArr = secondPart.toCharArray();
		 	while(start<end){
		 		char tmp = chArr[start];
		 		chArr[start] = chArr[end];
		 		chArr[end] = tmp;
		 		start++;
		 		end--;
		 	}
		
		 	
		 	secondPart = String.valueOf(chArr);
		 	if(firstPart.equals(secondPart))
		 		System.out.println("Yes");
		 	else
		 		System.out.println("No");
	}

}
