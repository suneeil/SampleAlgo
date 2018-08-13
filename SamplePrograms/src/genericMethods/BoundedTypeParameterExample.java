package genericMethods;

public class BoundedTypeParameterExample {

	//A Generic method that can biggest of Integer and alphabets in lexing
	public static <T extends Comparable<T>> T bigger(T val1, T val2){
		T big = val1;
		if(val2.compareTo(big) > 0) // the compareTo will give greater than zero if val2 is greater else will less than zero 
		{	
			big = val2;
		}else if(val2.compareTo(big)==0){
			big = null;
		}
		return big;
	}
	
	public static void main(String args[]){
	
			System.out.println(" Bigger of 1 and 3 is: "+ bigger(1, 3));
			System.out.println(" Bigger of 2.2 and 2.6 is: "+ bigger(2.2, 2.6));
			System.out.println(" Bigger of A and B is: "+ bigger("A", "B"));
			System.out.println(" Bigger of 5 and 5 is: "+ bigger("5", "5"));
			
			
			System.out.println("----------------------------------");
			System.out.println("when using compareTo method if a = a: " + "a".compareTo("a")); // output = zero 
			System.out.println("when using compareTo method if a > b: " + "a".compareTo("b")); // output = -1
			System.out.println("when using compareTo method if b > a: " +"b".compareTo("a")); //output = 1
			System.out.println("----------------------------------");
			Integer num1,num2;
			num1= 1; num2 = 2;
			System.out.println("when using compareTo method if 1 = 1: " + num1.compareTo(num1)); // output = zero 
			System.out.println("when using compareTo method if 1 > 2: " + num1.compareTo(num2)); // output = -1
			System.out.println("when using compareTo method if 2 > 1: " + num2.compareTo(num1)); //output = 1
	}
	
}
