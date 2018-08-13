package com.my.algorithm.utils;

public class SimpleUtils {

	public boolean stringToBoolean(String value) {
		
		if(value == null)
			return false;
		
		if("y".equalsIgnoreCase(value) || "YES".equalsIgnoreCase(value) || "true".equalsIgnoreCase(value))
			return true;
		
		return false;
	}
	
}
