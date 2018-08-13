package recursion;

public class SumOfNNaturalNumUsingRecursion {

	public static void main(String[] args) {
		System.out.println(addNum(2));
		System.out.println(recurSum(2));
		
	}
	
	
	public static int addNum(int num){
		if(num==0)
			return 0;
		else if(num ==1)
			return 1;
		else {
			return num + addNum(num-1);
		}
		
	}

	
	public static int recurSum(int num){
		if(num==0)
			return 0;
		else if(num==1)
			return 1;
		else{
			return num+recurSum(num-1);
		}
	}
}
