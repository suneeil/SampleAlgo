package com.org.APITest;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import static io.restassured.path.json.JsonPath.*;
import static io.restassured.RestAssured.*; //Creating a Static import so that we dont have to create a Object for it

public class Test_SetRequestData {

	/**
	 * Generally CONNECT is used with HTTPS request
	 * reffer https://stackoverflow.com/questions/11697943/when-should-one-use-connect-and-get-http-methods-at-http-proxy-server
	 */
	//@Test
	public void testCONNECTRequest(){
		when().
			request("CONNECT", "https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
		
	/**
	 * In GET request we can set query parameters
	 */
	//@Test
	public void testQueryParam(){
		given().
			queryParam("A", "Aval").
			queryParam("B", "Bval").
		when().
			get("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	/**
	 * In POST request we can set form parameters
	 */
	//@Test
	public void testFORMParam(){
		given().
			formParam("A", "Aval").
			formParam("B", "Bval").
		when().
			post("https://api.fonts.com/rest/json/Domains/").
		then().
			statusCode(400);
	}
	
	/**
	 * RestAssure recomends to use param to set parameters for GET and POST methods
	 * If request is GET  then param will be treated as Query Parameter
	 * If request is POST then paran will be treated as FORM parameter
	 */
	//@Test
	public void testSetParam(){
		given().
			param("A", "Aval").
			param("B", "Bval").
		when().
			post("https://api.fonts.com/rest/json/Domains/").
		then().
			statusCode(400);
	}	
	
	/**
	 * To set multiple value parameter
	 * We can pass multiple values or no values in param
	 */
	@Test
	public void testSetMultipleValueParam(){
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		given().
			param("A", "val1","val2","val3").
			param("B", "Bval").
			param("C", list).
		when().
			post("https://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
}
