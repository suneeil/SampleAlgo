package reflections1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionDemo {

	public static void main(String[] args) throws ClassNotFoundException {
			
		
		String nameOfMethod = "ename";
		Class c1 = Class.forName("reflections1.Employee");
		Employee e = new Employee();
		Class c2 = e.getClass();
		Class c3 = Employee.class;  
		System.out.println("Done");
		
		
		System.out.println("Name: "+ c3.getName());
		System.out.println("Super Class: "+ c3.getSuperclass().getSimpleName());
		System.out.println("Get Interfaces: "+Arrays.toString(c3.getInterfaces()));
		System.out.println("Get Methods: "+ Arrays.toString(c3.getMethods()));
		
			Method[] methods = c3.getMethods();
			List<String> mName = new ArrayList<String>();
			//System.out.println("Methods: \n"+Arrays.toString(methods));
			for(Method m : methods){
				mName.add(m.getName());
				if(m.getName().equals(nameOfMethod)){
					//m.invoke(obj, args);
					System.out.println("Try to invoke: "+ m.getName());
				}
				
			}
			
		System.out.println(mName);
		
		if(mName.contains("")){
			
		}
		
	}

}
