package creationDesignePattern.abstractFactoryDesignePattern;

public class Client {
	public static void main(String args[]){
		AnimalFactory animalFactory= null;
		Animal animal = null;
		String speakSound = null;
		
		animalFactory = AnimalFactory.getAnimalFactory("sea");
		
		System.out.println("Animal Factory Type: "+ animalFactory.getClass().getSimpleName());
		animal = animalFactory.getAnimal("shark");
		
		speakSound = animal.speak();
		System.out.println("Animal Speak as  " + speakSound);
		
		System.out.println("---------------------------------");
		
		animalFactory = AnimalFactory.getAnimalFactory("land");
		System.out.println("Animal Factory Type: " + animalFactory.getClass().getSimpleName());
		animal = animalFactory.getAnimal("lion");
		speakSound = animal.speak();
		System.out.println("Animal Speak as "+ speakSound);
		
		
		
	}
}
