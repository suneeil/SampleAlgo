package com.org.APITest;

import static io.restassured.RestAssured.*; 
import org.testng.annotations.Test;
//Creating a Static import so that we dont have to create a Object for it
public class Test_PathParameters {

	/**
	 * Set PATH parameters
	 * i.e. http://api.fonts.com/rest/{type}/{section}/
	 */
	@Test
	public void testSetPathParameter(){
		given().
			pathParam("type", "json").
			pathParam("section", "Domains").
		when().
			post("http://api.fonts.com/rest/{type}/{section}/").
		then().
			statusCode(400);
	}
	
	
	
}
