package recursion;

public class GCDRecur {

	public static void main(String[] args) {
		
		System.out.println(gcd(12,8));
		System.out.println(gcd2(8,12));
	}

	
	public static int gcd(int a, int b){
			if(a==b)
				return a;
			if((a%b)==0)
				return b;
			if((b%a)==0)
				return a;
			if(a>b)
				return gcd(a%b,b);
			else
				return gcd(a,b%a);
		
	}
	
	
	public static int gcd2(int p, int q) {        
    	if (q == 0) {
                    return p;
            }
            return gcd(q, p % q);
    }

	
}
