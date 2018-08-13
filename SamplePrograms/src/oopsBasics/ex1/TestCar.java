package oopsBasics.ex1;

public class TestCar {
	public static void main(String[] args) {
		Car c = new Car();
		c.start();
		c.stop();
		c.e.eName="Engine X";
		System.out.println("--------------");
		AudiCar a = new AudiCar();
		a.start();
		a.stop();
		a.openGPS();
		a.e.eName="Engine Y";
	}
}
