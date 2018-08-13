package encapsulation_Inherit;

public class Car {
	Engine engine;
	String carName;
	
	public void start(){
		engine = new Engine();
		engine.startEngine();
		System.out.println("Car Started");
	}
	public void stop(){
		System.out.println("Car Stop");
	}
	
}
