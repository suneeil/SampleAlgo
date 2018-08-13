package com.org.APITest;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestBasicFunctionsForJsonResponse {
	//Just check the status Code
	//@Test
	public void testStatusCode(){
		Response resp = given().
		get("http://jsonplaceholder.typicode.com/posts/3");
		System.out.println("Actual Status Code: " + resp.statusCode());
		resp.
		then().
		statusCode(200);
	}
	
	//Print Response to console and also verify the status code
	//@Test
	public void testLogging(){
		given().
		get("http://services.groupkt.com/country/get/iso2code/in").
		then().
		statusCode(200).
		log().all();
	}
	
	//Verifying single content using "equalTo" method under org.hamcrest.Matchers library 
	//@Test
	public void testEqualToFunction(){
		given().
		get("http://services.groupkt.com/country/get/iso2code/us").
		then().
		body("RestResponse.result.name", equalTo("United States of America"));
	}
	//Verify Multiple Content using org.hamcrest.Matchers library 
	//@Test
	public void testHasToFunction(){
		given().
		get("http://services.groupkt.com/country/get/all").
		then().
		body("RestResponse.result.name", hasItems("Afghanistan","American Samoa","Australia", "India"));
	}
	
	//Setting Parameters and headers
	//@Test
	public void testParametersAndHeaders(){
		given().
		param("key1", "value1").
		header("headA","valueA").
		header("headerB","valueB").
		get("http://services.groupkt.com/country/get/all").
		then().
		statusCode(200).
		log().all();
	}
	
	//Using "and" keyword to increase readability
	//It does NOT effect if you remove "and" keyword
	@Test
	public void testAndFeatureForReadibility(){
		given().
		param("key1", "value1").
		and().
		header("headA","valueA").
		and().
		header("headerB","valueB").
		get("http://services.groupkt.com/country/get/all").
		then().
		statusCode(200).
		and().
		body("RestResponse.result.name", hasItems("Afghanistan","American Samoa","Australia", "India"));
	}
}
