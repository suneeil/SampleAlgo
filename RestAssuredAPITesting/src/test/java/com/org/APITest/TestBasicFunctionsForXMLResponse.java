package com.org.APITest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import groovy.time.BaseDuration.From;
import groovy.transform.stc.FromString;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;

public class TestBasicFunctionsForXMLResponse {
	
	Response globalResponse;
	//Just to Get the Response	
	@Test
	public void getTheResponse(){
		globalResponse = given().
				when().
				get("http://thomas-bayer.com/sqlrest/CUSTOMER/10").then().extract().response();
		System.out.println("Assigned the Response to resp ");
	}
	//The testResponseStatusCode 
	@Test(dependsOnMethods="getTheResponse")
	public void testResponseStatusCode(){
		System.out.println("--------------------------------------- \n"+globalResponse.asString()+"\n-----------------------------------");
		globalResponse.then().body("CUSTOMER.ID", equalTo("10")).and().contentType(ContentType.XML);
		System.out.println("Completed");
	}
	//Test single content in XML
	//@Test
	public void testXMLSingleContent(){
		given().
		when().
		get("http://thomas-bayer.com/sqlrest/CUSTOMER/10").
		then().
		body("CUSTOMER.ID", equalTo("10")).
		log().all();
	}
	
	//Test XML response for multiple body content
	//@Test
	public void testXMLMultipleContent(){
		given().
		when().
		get("http://thomas-bayer.com/sqlrest/CUSTOMER/10").
		then().
		body("CUSTOMER.ID", equalTo("10")).
		body("CUSTOMER.FIRSTNAME", equalTo("Sue")).
		body("CUSTOMER.LASTNAME", equalTo("Fuller")).
		body("CUSTOMER.CITY", equalTo("Dallas"));
	}
	
	//Verify the entire text response in one go
	//@Test
	public void testCompleteTextinOneGo(){
		given().
			get("http://thomas-bayer.com/sqlrest/CUSTOMER/10").
		then().
			body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas")).log().all();
	}
	//Using Xpath to parse and verify
	//@Test
	public void testUsingXpath(){
		given().
			get("http://thomas-bayer.com/sqlrest/CUSTOMER/10").
		then().
			body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Sue")).log().all();
	}
	//Xpath Types
	//@Test
	public void testUsingXpath2(){
		given().
			get("http://thomas-bayer.com/sqlrest/INVOICE").
		then().
			body(hasXPath("/INVOICEList/INVOICE[text()='4']"));
		
		String resp = get("").asString();
		
		
	}
}
