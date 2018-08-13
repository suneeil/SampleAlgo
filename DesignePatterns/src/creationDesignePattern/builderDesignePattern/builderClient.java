package creationDesignePattern.builderDesignePattern;

public class builderClient {

	public static void main(String[] args) {
		
		Beverage tea = HotelWaiter.takeOrder("Tea");
		System.out.println(tea);
		
		Beverage coffee = HotelWaiter.takeOrder("coffee");
		
		Beverage milkShake = HotelWaiter.takeOrder("milkshake");
		
		
	}

}
