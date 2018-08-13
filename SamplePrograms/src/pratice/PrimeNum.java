package pratice;

public class PrimeNum {

	public static void main(String[] args) {
		int num = 9;
		
		
		System.out.println(isNumPrime(25));
	/*	System.out.println(Math.sqrt(625));
		boolean flag = false;
		for(int i=2; i< Math.sqrt(num); i++){
			if((num%i)==0){
				System.out.println(num + " is NOT a prime number\n because it is divisible by "+ i);
				flag=false;
				break;
			}else{
				flag=true;
			}
		}
		if(flag)
			System.out.println(num + " is a prime number");
		
		System.out.println(isPrime(num));*/
	}

	static boolean isPrime(int n) {
	    for(int i=2;2*i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public static boolean isNumPrime(int n){
		if (n <= 1) {
	           return false;
	       }
		
	       for (int i = 2; i < n/2; i++) {
	           if (n % i == 0) {
	               return false;
	           }
	       }
	       return true;
	   }
	
	public static boolean normalPrimeCheck(int n){
		return true;
	}
	
	
	}
	
	

