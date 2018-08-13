package creationDesignePattern.builderDesignePattern;

public class HotelWaiter {

	public static Beverage takeOrder(String beverageType){
		
			BeverageBuilder beverageBuilder = null;
			
				if(beverageType.equalsIgnoreCase("Tea")){
					beverageBuilder = new TeaBuilder();
				}else if (beverageType.equalsIgnoreCase("Coffee")){
					beverageBuilder = new CoffeeBuilder();
				}else{
					System.out.println("Sorry we don't take order for: "+ beverageType);
				}
		
		return beverageBuilder.buildBeverage();
		
	}
	
	
}
