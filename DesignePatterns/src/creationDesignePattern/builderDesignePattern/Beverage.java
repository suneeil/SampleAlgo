package creationDesignePattern.builderDesignePattern;

/*
 * 								1st create this where we identify what items are needed to create a product
 * 
 * Common items to create coffee or tea or any other milk beverage is present here
 * it has setter and getter methods for these attributes
 */
public class Beverage {

		private int water;
		private int milk;
		private int sugar;
		private int powderQuantity;
		private String beverageName;
		
		public int getWater(){
			return water;
		}
		
		public void setWater(int water){
			this.water = water;
		}
	
		public int getMilk(){
			return milk;
		}
		
		public void setMilk(int milk){
			this.milk = milk;
		}
		
		public int getSugar(){
			return sugar;
		}
		
		public void setSugar(int sugar){
			this.sugar = sugar;
		}
		
		public int getPowderQuantity(){
			return powderQuantity;
		}
		
		
		public void setPowderQuantity(int powderQuantity){
			this.powderQuantity = powderQuantity;
		}
		
		public String getBeverageName(){
			return beverageName;
		}
		
		public void setBeverageName(String beverageName){
			this.beverageName = beverageName;
		}
}
