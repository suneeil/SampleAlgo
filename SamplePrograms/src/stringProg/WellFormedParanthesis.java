package stringProg;

public class WellFormedParanthesis {

	public static void main(String[] args) {
	/*	String str1 = "{{{{}}}}{}{}{}{}{}{}{}{}{}{}{{{}}}";
		String str2 = "{{}{{{}}}{}}";
		String str3 = "}{";
		  System.out.println(str1+": "+wellFormed(str1));
		  System.out.println(str2+": "+wellFormed(str2));
		  System.out.println(str3+": "+wellFormed(str3));*/
	}

	
	public static boolean wellFormed(String str){
		char[] ch = str.toCharArray();
		
		int openPara = 0;
		int closedPara = 0;
		boolean isMatch = false;

		for(int i=0; i<str.length(); i++){
			char x = str.charAt(i);
				if(x=='{')
					openPara++;
				else if(x=='}')
					closedPara++;
				if(closedPara>openPara)
					return false;
		}
		if(openPara==closedPara)
			return true;
		else
			return false;
		
		
	}
	
}
