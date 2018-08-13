package stringProg;

public class LexoGraphEx {

	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "java";
		sumStrLen(str1, str2);
		islarger(str1, str2);
		converttoupper(str1, str2);
		
		
	}

		
	public static void islarger(String str1, String str2){
		if((str1.compareTo(str2))<0)
			System.out.println("NO");
		else if((str1.compareTo(str2))>0)
			System.out.println("YES");
		else if((str1.compareTo(str2))==0)
			System.out.println("str1 and str2 are same");
	}
	
	
	public static String captlizeFirstCh(String str){		
		return str.substring(0, 1).toUpperCase()+str.substring(1).toLowerCase();
		
	}
	
	public static void  converttoupper(String str1, String str2){
		System.out.println(captlizeFirstCh(str1)+" "+captlizeFirstCh(str2));
		
		
	}
	
	public static void sumStrLen(String str1, String str2){
		System.out.println(str1.length()+str2.length());
	}
	
	
}
