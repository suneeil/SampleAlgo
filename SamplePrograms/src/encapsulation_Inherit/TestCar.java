package encapsulation_Inherit;

public class TestCar {

	public static void main(String[] args) {
		
		Car c = new Car();
			c.start();
			c.stop();
		System.out.println("---------------------------");
		Audi audi = new Audi();
			audi.start();
			audi.stop();
			audi.openGPS();
			audi.engine.engineName = "Audi Engine";
			System.out.println(audi.engine.engineName);
	}

}
