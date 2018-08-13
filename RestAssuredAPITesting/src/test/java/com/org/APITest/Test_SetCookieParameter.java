package com.org.APITest;
import static io.restassured.RestAssured.*; 
import io.restassured.http.ContentType;

import org.testng.annotations.Test;

public class Test_SetCookieParameter {

	/**
	 * Cookie can be set in request parameter
	 */
	//@Test
	public void testSetCookieParameter(){
		given().
			cookie("__utmt","1").
			param("op", "GetCitiesByCountry").
		when().
			get("http://www.webservicex.com/globalweather.asmx").
		then().
			statusCode(200);
	}
	
	/**
	 * Set Multiple Cookies
	 */
	//@Test
	public void testSetMultipleCookieParameter(){
		//To DO
	}
	/**
	 * Set Detailed Cookies
	 */
	//@Test
	public void testSetDetailedCookieParameter(){
		//To do
	}
	
	/**
	 * Set Header there three ways 
	 * 1. set one key and one Value
	 * 2. Set One and multiple values
	 * 3. Set multiple keys and multiple values
	 */
	//@Test
	public void testSetHeader(){
		given().
			header("k","v").
			header("k10", "val1", "val2","val3","....").
			headers("k1","v1","k2","v2","k3","v3").
		when().
			get("https://api.fonts.com/rest/json/Accounts").
		then().
			statusCode(200);
	}
	
	/**
	 * Set Content type
	 */
	@Test
	public void testSetContent(){
		given().
			contentType(ContentType.JSON).
			contentType("application/json; charset=utf-8").
		when().
			get("https://api.fonts.com/rest/json/Accounts").
		then().
			statusCode(200);
	}
}
