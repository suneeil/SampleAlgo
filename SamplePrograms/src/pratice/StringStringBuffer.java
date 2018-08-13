package pratice;

class StringStringBuffer {

	public static void main(String[] args) {
		String s1 = new String("Test");
		s1.concat("Data");
		System.out.println(s1);
		
		StringBuffer s2 = new StringBuffer("Test");
		s2.append("Data");
		System.out.println(s2);

	}

}
