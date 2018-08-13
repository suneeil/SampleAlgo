package genericMethods;

public class GenericMethodTest {

	
	public static <SUNIL> void printArray(SUNIL[] inputArray){
	
		System.out.print("[");
		for(SUNIL element : inputArray){
			
			System.out.print(" "+element);
		}
		System.out.print("]\n");
	}
	
	
	public static void main(String[] args) {
			Integer[] intArray = {1,2,3,4,5,6};
			Double[] doubleArray = {1.1, 1.2, 1.3, 1.4};
			Character[] charArray = {'A', 'B', 'C', 'E'};
			String[] strArray = {"SUNIL", "ASHU", "NISHKA"};
			System.out.println("Integer Array Contains");
			printArray(intArray); //Passing Integer Array
			
			System.out.println("Double Array Contains");
			printArray(doubleArray); // Passing Double Array
			
			System.out.println("Character Array Contains");
			printArray(charArray); //Passing Character Array

			System.out.println("String Array Contains");
			printArray(strArray); //Passing String Array

			
	}

}
