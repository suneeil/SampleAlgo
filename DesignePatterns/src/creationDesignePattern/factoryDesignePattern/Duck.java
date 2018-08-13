package creationDesignePattern.factoryDesignePattern;

public class Duck implements Animal{

	@Override
	public String speak() {
		return "Quack Quack...";
	}

	@Override
	public String run() {
		// TODO Auto-generated method stub
		return "Cannot run, can only walk . Quack Quak ....";
	}

}
