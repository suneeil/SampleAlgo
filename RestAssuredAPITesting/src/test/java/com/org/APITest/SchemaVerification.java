package com.org.APITest;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*; //Creating a Static import so that we dont have to create a Object for it
import io.restassured.config.MatcherConfig;
import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaVerification {
	
	//Test to verify the response schema with the preferred existing schema
	/*
	 * SAMPLE JSON SCHEMA
	 * {
	 * 	"$schema":"http://json-schema.org/draft-04/schema#",
	 * 	"RestResponse" :{
	 * 		"country"	:	"integer",
	 * 		"state"		:	"string",
	 * 		"postal"	:	"integer"
	 * 	}
	 * } 
	 */

	@Test
	public void testSchema(){
		given().
			get("http://localhost:3000/posts").
		then().
			assertThat().body(JsonSchemaValidator.matchesJsonSchema("PATH TO FILE"));
	}
}
