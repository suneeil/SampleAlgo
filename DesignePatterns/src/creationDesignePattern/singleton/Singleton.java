package creationDesignePattern.singleton;

public class Singleton {

	private static Singleton singletonInstance;
	
	
	private Singleton(){
		
	}
	
	public static Singleton getSingletonInstance(){
		if(singletonInstance == null){
			singletonInstance = new Singleton();
			System.out.println("Inside null check, Object is created: " + singletonInstance.toString());
			System.out.println("-----------------------------------------------------------------------");
		}		
		return singletonInstance;
		
	}
	
	
	
	public void printSingleton(){
		System.out.println("Inside print Singleton Object: "+ singletonInstance.toString());
		System.out.println("");
	}
	
	
}
