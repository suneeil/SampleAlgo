package pratice;

import java.util.Scanner;

public class ComparisonPointsEx {

	public static void main(String[] args) {
		System.out.println("Enter");
		 Scanner in = new Scanner(System.in);
	        int a0 = in.nextInt();
	        int a1 = in.nextInt();
	        int a2 = in.nextInt();
	        int b0 = in.nextInt();
	        int b1 = in.nextInt();
	        int b2 = in.nextInt();
	        int Apoint = 0;
	        int Bpoint = 0;
	        
	        System.out.println(a0 + " " + a1 + " "+ a2);
	        System.out.println(b0 + " " + b1 + " "+ b2);
	        
	        	if(a0 > b0)
	        		Apoint = 1;
	        	else if(a0 < b0)
	        		Bpoint = 1;
	        	
	        	if(a1 > b1)
	        		Apoint = Apoint + 1;
	        	else if(a1 < b1)
	        		Bpoint = Bpoint + 1;
	        	
	        	if(a2 > b2)
	        		Apoint = Apoint + 1;
	        	else if(a2 < b2)
	        		Bpoint = Bpoint + 1;
	        	
	        System.out.println("Points: "+ Apoint + " "+ Bpoint);
	}

}
