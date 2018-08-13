package stringProg;
public class StringCompression {
	
	public String compression(String str){
		
		StringBuffer sb = new StringBuffer();
		int count = 1;
		
			for(int i=0; i<str.length()-1; i++){
				if(str.charAt(i)==str.charAt(i+1)){
					count ++;
				}else{
					sb.append(str.charAt(i));
					sb.append(count);
					count = 1;
				}
			}
			//Here we are appending because the last part of the string does not get appended
			sb.append(str.charAt(str.length()-1));
			sb.append(count);
		
		if(sb.length()>str.length())
			return str;
		else
		return sb.toString();
		//return "";
	}
	public static void main(String args[]){
		String s1 = "ssssuuuummmmmmiiiittttttttttttt";
		StringCompression sc = new StringCompression();
		System.out.println("Compression of " + s1 + " is : " +sc.compression(s1));
		s1 = "Jaain";
		System.out.println("Compression of " + s1 + " is : " +sc.compression(s1));
		s1 = "AshwiniGundappanavar";
		System.out.println("Compression of " + s1 + " is : " +sc.compression(s1));
	
	}
}
