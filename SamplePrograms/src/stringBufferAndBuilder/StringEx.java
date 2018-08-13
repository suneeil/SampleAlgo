package stringBufferAndBuilder;

public class StringEx {

	public static void main(String[] args) {
		String s = "Sunil";
		s.concat(" Rao"); 
		System.out.println(s);
		System.out.println("-------------------------");
		StringBuffer sb = new StringBuffer("Sunil");
		sb.append(" Rao");
		System.out.println(sb);
		
	}

}
