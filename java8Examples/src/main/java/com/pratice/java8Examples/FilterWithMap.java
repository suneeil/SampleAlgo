package com.pratice.java8Examples;


import java.util.Arrays;
import java.util.List;

public class FilterWithMap {

	public static void main(String[] args) {
		List<Human> humans = Arrays.asList(
				new Human("Raj", 30),
				new Human("Bob", 32),
				new Human("Tom", 28)
				);
		
		String getNameMethodAsString = humans.stream().filter(x -> "Tom".equals(x.getName()))
				.map(Human::getName)  //Converting Stream to String
				.findAny()
				.orElse(null); //Hence We add a String 
		
		int getAgeMethodAsInt = humans.stream().filter(x -> "Tom".equals(x.getName()))
		.map(Human::getAge)  //Converting Stream to int
		.findAny()
		.orElse(null); //Hence We add a String
		
		
		Human getTheObject = humans.stream().filter(x -> "Tom".equals(x.getName()))
		.findAny()
		.orElse(null);
		
		System.out.println(getNameMethodAsString);
		System.out.println(getAgeMethodAsInt);
		System.out.println(getTheObject);

	}
	
	
}

class Human {
	private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString(){
		return "Human{Name = '"+getName() + "', Age = " + getAge()+"}";
	}
	

    
}