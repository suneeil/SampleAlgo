package com.pratice.java8Examples;


import java.util.Arrays;
import java.util.List;

public class FilterWithMultipleConditions {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Sam", 20),
				new Person("Tom", 23),
				new Person("Paul", 40));
		
		Person res = persons.stream().filter((person) -> "Sam".equals(person.getName()) && 20 == person.getAge()).findAny().orElse(null);
			//OR
		Person res2 = persons.stream().filter(p ->{
			if("Tom".equals(p.getName()) && 20 == p.getAge()){
				return true;
			}
			return false;
		}).findAny().orElse(null);
		
		System.out.println(res);
		System.out.println(res2);
	}

}

class Person {
	private String name;
    private int age;

    public Person(String name, int age) {
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
		return "Peson{Name = '"+getName() + "', Age = " + getAge()+"}";
	}
	

    
}