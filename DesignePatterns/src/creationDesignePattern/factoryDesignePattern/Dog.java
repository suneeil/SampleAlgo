package creationDesignePattern.factoryDesignePattern;

public class Dog implements Animal {

	public String speak() {
		return "Bow Wow....";
	}

	//@Override
	public String run() {
		// TODO Auto-generated method stub
		return "Running .....";
	}
	
	public void swim(){
		System.out.println("The dog can swim too...");
	}


}
