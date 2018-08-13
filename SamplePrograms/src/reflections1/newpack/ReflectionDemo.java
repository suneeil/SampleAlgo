package reflections1.newpack;

import reflections1.Employee;

public class ReflectionDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		Class c1 = Class.forName("reflections1.Employee");
		Employee e = new Employee();
		Class c2 = e.getClass();
		Class c3 = Employee.class;  
		System.out.println("Done");
	}

}
