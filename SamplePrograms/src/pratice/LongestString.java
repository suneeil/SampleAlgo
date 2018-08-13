

/*import java.util.regex.Pattern;

public class LongestString {

	public static void main(String[] args) {
		String str = "fun&!! time";
		Pattern p = Pattern.compile("a-zA-Z");
		String[] strArr = str.split("\\s");
		System.out.println(strArr.length);
		int bigWordLength = 0;
		String bigWord =null;
		if(strArr.length>0){
			
			if(strArr.length == 1){
				bigWord = strArr[0];
			}
				
			else{
				for(int i=0;i<=(strArr.length)-1;i++){
					if(strArr[i].replaceAll("[^\\w\\s-]","").length()>bigWordLength)
						{
							bigWord = strArr[i];
							bigWordLength = strArr[i].length();
							
						}
				}
			}
		}
			System.out.println("Big Word: "+ bigWord);
	}

}*/
