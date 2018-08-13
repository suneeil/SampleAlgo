package recursion;

public class ReverseStr {
	public static void main(String[] args) {
		System.out.println(rev("SUNIL"));
		usingStrBuffer("SUNIL");
		usingSwap("ABC");
	}
	public static String rev(String str){
		if(str.length()==1||str.length()==0)
		return str;
		else{			
			return rev(str.substring(1))+str.charAt(0);
		}
	}
	public static void usingStrBuffer(String str){
		StringBuffer buf = new StringBuffer(str);
		System.out.println(buf.reverse());
	}
	public static void usingSwap(String str){
		char[] chArr = str.toCharArray();
		int len =chArr.length-1;
		int mid, start=0,end=len;
		char temp;
		mid=(start+end)/2;
		while(start<=mid && end>=mid){
			temp = chArr[end];
			chArr[end]=chArr[start];
			chArr[start]=temp;
			start++;
			end--;
		}
		System.out.println(chArr);
	}	
}
