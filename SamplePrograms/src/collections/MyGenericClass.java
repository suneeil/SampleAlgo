package collections;

public class MyGenericClass<T> {

	T genType = null;
	
	public void set(T genType){
		this.genType = genType;
	}
	
	public T get(){
		System.out.println(this.genType+ " is "+this.genType.getClass().getSimpleName() + " Class");
		return genType;
	}
	
	public static void main(String args[]){
		MyGenericClass<String> strGen = new MyGenericClass<>();
		strGen.set("Sunil");
		
		MyGenericClass<Integer> integerGen = new MyGenericClass<Integer>();
		integerGen.set(23);
		
		strGen.get();
		integerGen.get();
		
	}
}
