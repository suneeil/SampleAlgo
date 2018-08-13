package com.pratice.java8Examples;

public class DiffStrEquals {

	public static void main(String[] args) {
		String str = null;
		try{
		    if(str.equals("test")) {  // NullPointerException
		        System.out.println("After");
		    }
		}catch(Exception e){
			System.out.println("Cought Exception");
		}
		
	    if("test".equals(str)) {  // No Exception will be thrown. Will return false
	        System.out.println("Before");
	    }else{
	    	System.out.println("Nothing");
	    }

	}

}
