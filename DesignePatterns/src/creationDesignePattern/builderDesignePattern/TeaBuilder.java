package creationDesignePattern.builderDesignePattern;

/*
 * Tea builder create coffee by mixing the components [water, milk, sugar , Tea powder]
 * It implements BeverageBuilder which is bluePrint for creating a beverage
 */


public class TeaBuilder extends BeverageBuilder{

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
		System.out.println("------ Tea ------");
		getBeverage().setBeverageName("Tea");
	}


	@Override
	void setMilk() {
		System.out.println("Step 2: Addding milk");
		getBeverage().setMilk(20);
		
	}

	@Override
	void setSugar() {
		System.out.println("Step 3: Adding sugar");
		getBeverage().setSugar(20);
		
	}

	@Override
	void setPowderQuantity() {
		System.out.println("Step 4: Adding 15 grams of Tea powder");
		getBeverage().setPowderQuantity(15);
		
	}

}
