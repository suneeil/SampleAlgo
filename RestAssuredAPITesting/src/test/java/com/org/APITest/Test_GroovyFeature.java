package com.org.APITest;



import java.util.List;

import org.testng.annotations.Test;

import static io.restassured.path.json.JsonPath.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*; //Creating a Static import so that we dont have to create a Object for it

public class Test_GroovyFeature {
	
	
	
	
	//To verify if some expected name is present in response or not
	//@Test
	public void testPresenceOfElements(){
		given().
			get("http://services.groupkt.com/country/search?text=lands").
		then().
			body("RestResponse.result.name", hasItems("Cayman Islands","Marshall Islands","Cook Islands")).log().all();
	}
	
	/**
	 * Restassured implemented in groovy hencewe can take advantage of it
	 * Here we are adding length of all "alpha2_code" parameter coming from the response and check 
	 * if the total count is greater than expected number 
	 */
	//@Test
	public void testLengthOfResponse(){
		
		given().
			get("http://services.groupkt.com/country/search?text=lands").
		then().
			body("RestResponse.result.alpha3_code*.length().sum()", greaterThan(40));
		
		String name = given().
			get("http://services.groupkt.com/country/search?text=lands").
		then().extract().jsonPath().get("RestResponse.result.name").toString();
		System.out.println(name);
	}
	
	/**
	 * Getting all the attributes from the response and assigning to list
	 */
	//@Test
	public void testGetResponseAsList(){
		
			String response = get("http://services.groupkt.com/country/search?text=lands").asString();
			List<String> list = from(response).getList("RestResponse.result.name");
			//add a for loop for list and check that list has the expected string
			for(String country : list){
				if(country.equals("Cook Islands"))
					System.out.println("Found Country");
				else
					System.out.println("Other Countries: "+ country);
			}
	}
	
	/**
	 * To get the respose as list and apply some conditionson it
	 */
	@Test
	public void testConditionsOnList(){
		String response = get("http://services.groupkt.com/country/search?text=lands").asString();
		List<String> ls = from(response).getList("RestResponse.result.findAll{ it.name.length() > 40}"); //looking for a name whose length is greater than 40 character len
		System.out.println(ls);
	}
}
