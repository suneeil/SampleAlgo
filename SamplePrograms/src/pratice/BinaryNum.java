package pratice;



public class BinaryNum {

	public static void main(String[] args) {
		int[]  binary = new int[25];
		int num = 357;
		int i=0;
		while(num>0){
			binary[i++] = num%2;
			//System.out.println("Binary num: "+num%2);
			num = num/2;
			//System.out.println("num: "+num);
		}
		for(int j=binary.length-1; j>=0;j--){
			System.out.print(binary[j]);
		}
	}
	
	
}
