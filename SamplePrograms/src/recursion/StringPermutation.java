package recursion;


public class StringPermutation {
	  public static void main(String args[]) {
		System.out.println("B".substring(0,1)+"B".substring(2));  
	   permuteString("", "AB");
	  
	  }

	  // ------------ https://www.youtube.com/watch?v=WHR1trMsvOE
	  
	  public static void permuteString(String beginningString, String endingString) {
	  
		  if (endingString.length() == 0){//checking if there is only one character
	      System.out.println("---> "+beginningString);//i.e. If you send 'A' you get the result as 'A'
	      return;
	    }else
	      for (int i = 0; i < endingString.length(); i++) {
	        	String newString = endingString.substring(0, i) + endingString.substring(i + 1);
	        	permuteString(beginningString + endingString.charAt(i), newString);
	      								//OR
	      
	      //	permuteString(beginningString+endingString.charAt(i), endingString.substring(0,i)+endingString.substring(i+1,endingString.length()));
	        	
	      }
	  }
	}
/**/