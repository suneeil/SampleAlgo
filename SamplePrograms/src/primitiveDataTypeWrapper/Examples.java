package primitiveDataTypeWrapper;

public class Examples {

	public static void main(String[] args) {
		Integer n = 25;
		System.out.println(n.doubleValue());
		Float fl = 12.00f;
		System.out.println(fl.intValue());
		System.out.println(n.intValue());
		int n1 = Integer.parseInt("12"); //Returns int
		Integer n2 = Integer.valueOf("12"); //Returns Integer
		System.out.println(n1+n2);
		

	}

}
