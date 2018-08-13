package com.org.APITest;

import static io.restassured.path.json.JsonPath.*; //Needed
import static org.hamcrest.Matchers.*; //needed
import static io.restassured.RestAssured.*; // needed Creating a Static import so that we dont have to create a Object for it
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath; //
import io.restassured.response.Response;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

public class Test_VerifyResponse {

	
	/**
	 * Status Code verification
	 */
	//@Test
	public void testStatusInResponse(){
		given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().statusCode(200).log().all();
		given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().statusLine("HTTP/1.1 200 OK");
		given().get("http://jsonplaceholder.typicode.com/photos/").then().assertThat().statusLine(containsString("OK"));
	}
	
	/**
	 * Body text veriication, i.e. compare two json responses
	 */
	//@Test
	public void testBodyResponse(){
		String expResponse = get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02").asString();
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/02").then().assertThat().body(equalTo(expResponse));
	}
	
	/**
	 * verify cookie, In the below test the test fails because the cookie value always changes
	 */
	//@Test
	public void testCookieInResponse(){
		
		given().get("http://jsonplaceholder.typicode.com/comments").then().log().all().assertThat().cookie("__cfduid", "");
	}
	/**
	 * Body attribute verification using Java 8 lambda expression
	 */
	@Test
	public void testBodyParameterInResponse(){
		//--------------------------- Using Java7 ---------------------------
		given().
			get("http://jsonplaceholder.typicode.com/photos/1").
		then().
			body("thumbnailUrl", new ResponseAwareMatcher<Response>() {
				@Override
				public Matcher<?> matcher(Response arg0) throws Exception {
					return equalTo("http://placehold.it/150/92c952");
				}
			});
		//--------------------------- Using Java8 ---------------------------
		given().get("http://jsonplaceholder.typicode.com/photos/1").then().body("thumbnailUrl", respnse -> equalTo("http://placehold.it/150/92c952"));
		
		//-----------
		given().get("http://jsonplaceholder.typicode.com/photos/1").then().body("thumbnailUrl",endsWith("92c952"));
	}
}
