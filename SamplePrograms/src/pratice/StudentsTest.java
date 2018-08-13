package pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentsTest {

	public static void main(String[] args) {
		ArrayList<Student> student  = new ArrayList<>();
		student.add(new Student("Sunil", 10));
		student.add(new Student("Raj", 10));
		student.add(new Student("Ram", 12));
		student.add(new Student("Pandit", 1));
		student.add(new Student("Lona", 3));
		
		System.out.println(student);
		
		Collections.sort(student, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
		
		
		
	}

}

class Student {
	 private String name;
	    private int age;
	    
	    public Student(String name, int age){
	    	
	    	this.name = name;
	    	this.age = age;
	    }
	    
	    public String getName()
	    {
	        return this.name;
	    }

	    public int getId()
	    {
	        return this.age;
	    }

	    public boolean setName(String name)
	    {
	        this.name = name;
	        return true;
	    }

	    public boolean setIdNum(int id)
	    {
	        this.age = id;
	        return true;
	    }
	    
	    public String toString(){
	    	return String.format("{Name: "+name+", Age: "+age+"}");
	    }

}
