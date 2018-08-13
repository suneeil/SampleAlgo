package randomEx;

public class PrintStarts {

	public static void main(String[] args) {
		PrintStarts p = new PrintStarts();
		
		/*
		 * *
		 * * *
		 * * * *
		 * * * * *
		 * * * *
		 * * *
		 * * 
		 */
		p.printStr(3);
		
	}
	
	
	public void  printStr(int num){
		if(num<1){
			System.out.println();
			return;
		}	
			System.out.print("* ");printStr(num-1);
			printStr(num-1);
		
	}

}
