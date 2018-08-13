package recursion;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(recursiveFact(4));

	}
	
	public static int recursiveFact(int n){
		if(n==0){
			System.out.println("n==0 returning 1");
			return 1;
		}
		else if (n==1){
			System.out.println("n==1 returning 1");
			return 1;
		}
		else{
			System.out.println("n * fact(n-1)");
			return n * recursiveFact(n-1);
		}
	}
	
	public static int iterativeFact(int n){
		return 0;
	}

}
