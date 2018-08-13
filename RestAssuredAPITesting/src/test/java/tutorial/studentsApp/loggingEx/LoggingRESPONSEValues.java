package tutorial.studentsApp.loggingEx;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

import java.util.ArrayList;

import org.testng.annotations.Test;

import tutorial.studentsApp.CreateStudent.pojoClasses.StudentPOJO;
import tutorial.studentsApp.base.TestBase;

public class LoggingRESPONSEValues extends TestBase{
	
	/**
	 * Print all the Response Headers
	 */
	@Test
	public void printResponseHeaders(){
		System.out.println("----------------- Print Response Headers -----------------------");
		given()
			.param("programme", "Computer Science")
			.param("limit", 1)
		.when()
			.get("/list")
		.then()
			.log().headers()
			.statusCode(200);
		
	}
	/**
	 * Print all the Response status Line
	 */
	@Test
	public void printResponseStatusLine(){
		System.out.println("----------------- Print Response Status line -----------------------");
		given()
			.param("programme", "Computer Science")
			.param("limit", 1)
		.when()
			.get("/list")
		.then()
			.log().status()
			.statusCode(200);
		
	}
	
	/**
	 * Print all the Response bODY
	 */
	@Test
	public void printResponseBody(){
		System.out.println("----------------- Print Response Body -----------------------");
		given()
			.param("programme", "Computer Science")
			.param("limit", 1)
		.when()
			.get("/list")
		.then()
			.log().body()
			.statusCode(200);
		
	}
	
	/**
	 * Print all the Response body in case of error
	 */
	@Test
	public void printResponseOnFailure(){
		System.out.println("----------------- Print Response Body in case of Error -----------------------");
		given()
			.param("programme", "Computer Science")
			.param("limit", -1)
		.when()
			.get("/list")
		.then()
			.log().ifError();
		
	}
}
