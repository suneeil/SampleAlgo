package com.org.APITest;

import io.restassured.http.ContentType;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; //Creating a Static import so that we dont have to create a Object for it
import static org.hamcrest.Matchers.*;

public class Test_SettingRoot {

	//Testing without Root
	//@Test
	public void testWithoutRoot(){
		given().
		get("http://services.groupkt.com/country/get/iso3code/ita").
		then().
		body("RestResponse.result.name", is("Italy")).
		body("RestResponse.result.alpha2_code", is("IT")).
		body("RestResponse.result.alpha3_code", is("ITA"));
	}

	//Testing with the use of Root
	//@Test
	public void testWithRoot(){
		given().
		get("http://services.groupkt.com/country/get/iso3code/ita").
		then().
		root("RestResponse.result").	
		body("name", is("Italy")).
		body("alpha2_code", is("IT")).
		body("alpha3_code", is("ITA"));
	}

	//Detach root
	//@Test
	public void testDetachRoot(){
		given().
			get("http://services.groupkt.com/country/get/iso3code/ita").
		then().
			root("RestResponse.result").	
			body("name", is("Italy")).
			body("alpha2_code", is("IT")).
			detachRoot("result").
			body("result.name",is("Italy"));

	}
	//Extract Details using path
	//@Test
	public void testExtractDetailsUsingPath(){
		String uri = given().
			get("http://jsonplaceholder.typicode.com/photos/1").
		then().
			contentType(ContentType.JSON).	
			body("albumId", equalTo(1)).
		extract().
			path("url");	
		System.out.println("URI: " + uri);
	}
	
	//Extract Details using path in one line
	@Test
	public void testExtractDetailsInOneLine(){
		//Type 1:
		String uri = get("http://jsonplaceholder.typicode.com/photos/1").path("thumbnailUrl");			
		System.out.println("URI: " + uri);
		
		//Type 2:
		String uri2 = get("http://jsonplaceholder.typicode.com/photos/1").andReturn().jsonPath().get("thumbnailUrl");
		System.out.println("URI 2 : "+ uri2);
	}
	
}
