package creationDesignePattern.builderDesignePattern;

/*
 * Coffee builder create coffee by mixing the components [water, milk, sugar , coffee powder]
 * It implements BeverageBuilder which is bluePrint for creating a beverage
 */


public class CoffeeBuilder extends BeverageBuilder{

	

	@Override
	Beverage createBeverage() {
		return new Beverage();
	}	
	
	
	@Override
	void setWater() {
		System.out.println("Step 1: Boiling water");
		getBeverage().setWater(40);
		
	}

	@Override
	void setBeverageType() {
		System.out.println("---- Coffee -----");
		getBeverage().setBeverageName("Coffee");
	}


	@Override
	void setMilk() {
		System.out.println("Step 2: Addding milk");
		getBeverage().setMilk(50);
		
	}

	@Override
	void setSugar() {
		System.out.println("Step 3: Adding sugar");
		getBeverage().setSugar(20);
		
	}

	@Override
	void setPowderQuantity() {
		System.out.println("Step 4: Adding 10 grams of coffee powder");
		getBeverage().setPowderQuantity(10);
		
	}

}
