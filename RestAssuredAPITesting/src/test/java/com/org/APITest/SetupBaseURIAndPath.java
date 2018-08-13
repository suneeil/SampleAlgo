package com.org.APITest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*; //Creating a Static import so that we dont have to create a Object for it

public class SetupBaseURIAndPath {
	public static Response response;
    public static String jsonAsString;
	/**
	 * Setting Default URI and base path to use through out the test 
	 */
	@BeforeClass
	public static void setUpURL(){
		RestAssured.baseURI = "http://yourwebsitAddress";
		RestAssured.basePath = "/api/books/data/";
	}
	
	@BeforeClass
    public static void callRidesAPI()
    {
        // call the rides API, the full address is "http://yourwebsiteaddress.com/api/yourapi/rides",
        // but we set the default above, so just need "/rides"
        response =
            when().
                get("/rides").
            then().
                contentType(ContentType.JSON).  // check that the content type return from the API is JSON
            extract().response(); // extract the response

        // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
        jsonAsString = response.asString();
    }
}
