package pratice;

public class SwapWithoutTmp {

	int x ,y;
	
	public void setxy(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public static void main(String[] args) {
			swap(10, 20);
			System.out.println("--------------");
			SwapWithoutTmp sw = new SwapWithoutTmp();
			sw.x = 1;
			sw.y = 2;
			System.out.println(sw.x + " "+sw.y);
			sw.swapN(sw);
			System.out.println(sw.x + " "+sw.y);
	}

	public static void swap(int a, int b){
		System.out.println("Before Swap \n a: "+ a+", b: "+ b);
		System.out.println("After Swap \n a: "+ ((a+b)-a)+", b: "+ ((a+b)-b));		
	}
	
	public SwapWithoutTmp swapN(SwapWithoutTmp pointer){
		int temp = pointer.x;
		pointer.x = pointer.y;
		pointer.y = temp;		
		return pointer;
		
	}
	
}
