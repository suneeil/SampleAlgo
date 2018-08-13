package comparableAndcomporator;

import java.util.Comparator;

public class CustomStringSort implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		String obj1 = o1.toString();
		String obj2 = (String) o2;
		return -obj1.compareTo(obj2);
	}

}
