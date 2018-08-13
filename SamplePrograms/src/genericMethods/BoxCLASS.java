package genericMethods;

public class BoxCLASS<T>  {
	
	private T t;
	
	public void set(T t){
		this.t = t;
	}
	
	public T get(){
		return t;
	}
	
	
	public static void main(String[] args) {
		BoxCLASS<Integer> integerBox = new BoxCLASS<Integer>();
		BoxCLASS<String> stringBox = new BoxCLASS<String>();
		
		integerBox.set(20);
		stringBox.set("Sunil");
		
		System.out.println("Integer Value: "+ integerBox.get());
		System.out.println("String Value: "+ stringBox.get());
		

	}

}
