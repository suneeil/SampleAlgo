package creationDesignePattern.builderDesignePattern;

/**
 * 							2nd We create a common step template that needs to create a product 
 * 
 * 
 * BeverageBuilder is a blueprint for any class that wants to create Beverage.
 * It will have different subClass implementations of BeverageBuilder
 * for different Beverages [e.g. Coffee, tea, Horlicks,....etc]  
 *
 */

public abstract class BeverageBuilder {

	private Beverage beverage;
	
	public Beverage getBeverage(){
		return beverage;
		
	}
	
	public void setBeverage(Beverage beverage){
		this.beverage = beverage;
	}
	
	/*
	 * Template method that creates Beverage Object and return Beverage Object after adding components in required proportions 
	 */
	
	public final Beverage buildBeverage(){
		Beverage beverage = createBeverage();
		
		setBeverage(beverage);
		setBeverageType();
		setWater();
		setMilk();
		setSugar();
		setPowderQuantity();
		return beverage;
	}

	abstract void setWater(); 
	abstract void setBeverageType();
	abstract Beverage createBeverage();
	abstract void setMilk();
	abstract void setSugar();
	abstract void setPowderQuantity();
}
