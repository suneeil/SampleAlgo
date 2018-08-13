package com.org.APITest;
import java.util.List;

import org.testng.annotations.Test;

import static io.restassured.path.json.JsonPath.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*; //Creating a Static import so that we dont have to create a Object for it
import io.restassured.path.json.JsonPath;

public class Test_JsonPath {

	/**
	 * Extract JSON as a String and fetch further details without using json path
	 */
	//@Test
	public void testJsonPath1(){
		String responseAsString =	when().
										get("http://jsonplaceholder.typicode.com/photos").
									then().
										extract().asString();

		List<Integer> albumIds = from(responseAsString).get("id"); //To use from import "import static io.restassured.path.json.JsonPath.*;"
		System.out.println(albumIds.size());
	}
	
	/**
	 * Extract details as String and fetching further details using JSONPath
	 */
	@Test
	public void testJsonPath2(){
		String json = 
					when().
						get("http://services.groupkt.com/country/get/all").
					then().
						extract().asString();
		
		JsonPath jsonPath = new JsonPath(json).setRoot("RestResponse.result");
		List<String> nameList = jsonPath.get("name");
		System.out.println(nameList.size());
	}
}
