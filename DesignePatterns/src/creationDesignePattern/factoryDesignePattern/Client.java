package creationDesignePattern.factoryDesignePattern;

public class Client {
	public static void main(String args[]){
		AnimalFactory animalFactory = new AnimalFactory();
		Animal animal = null;
		Animal animal2 = null;
		String speakSound = null;
		
		animal = animalFactory.getAnimal("dog");
		animal2 = animalFactory.getAnimal("dog");
		System.out.println("*******************");
		System.out.println(animal + "--" + animal2 );
		System.out.println("Animal Type: "+ animal.getClass().getSimpleName());
		speakSound = animal.speak();
		System.out.println("Animal Speak as  " + speakSound);
		speakSound = animal2.speak();
		System.out.println("Animal 2 Speak as  " + speakSound);
		
		System.out.println("---------------------------------");
		
		animal = animalFactory.getAnimal("lion");
		System.out.println("Animal Type: "+ animal.getClass().getSimpleName());
		speakSound = animal.speak();
		System.out.println("Animal Speak as "+ speakSound);
		
		System.out.println("---------------------------------");
		
		animal = animalFactory.getAnimal("duck");
		System.out.println("Animal Type: "+ animal.getClass().getSimpleName());
		speakSound = animal.speak();
		System.out.println("Animal Speak as "+ speakSound);
		
		
		
	}
}
