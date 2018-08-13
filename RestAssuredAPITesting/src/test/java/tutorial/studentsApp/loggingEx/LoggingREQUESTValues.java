package tutorial.studentsApp.loggingEx;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

import java.util.ArrayList;

import org.testng.annotations.Test;

import tutorial.studentsApp.CreateStudent.pojoClasses.StudentPOJO;
import tutorial.studentsApp.base.TestBase;

public class LoggingREQUESTValues extends TestBase{
	/**
	 * Print the Headers
	 */
	//@Test
	public void printHeadersTest(){
		System.out.println("----------------- Print Headers -----------------------");
		given()
			.log()
			.headers()
		.when()
			.get("/1")
		.then()
			.statusCode(200);
		
	}
	/**
	 * Print all the request parameters
	 */
	//@Test
	public void printRequestParam(){
		System.out.println("----------------- Print Request Parameters -----------------------");
		given()
			.param("programme", "Computer Science")
			.param("limit", 1)
			.log().params() 
		.when()
			.get("/list")
		.then()
			.statusCode(200);
		
	}
	
	/**
	 * Test to print request body
	 */
	//@Test
	public void printRequestBody(){
		//Ensure to have unique Email
		System.out.println("-----------------  Request Body -----------------------");
		
		//Creating a Student Object 
		ArrayList<String> courses = new ArrayList<String>();
			courses.add("Ruby");courses.add("C++");
		StudentPOJO student = new StudentPOJO();
			student.setFirstName("Pet");
			student.setLastName("Sam");
			student.setProgramme("Computer Science");
			student.setEmail("sampet1@mail.com"); 
			student.setCourses(courses);
		//Post the Request 
		given()
			.contentType(ContentType.JSON)
			.log().body()
		.when()
			.body(student)
			.post()
		.then()
			.statusCode(201);
		
	}
	
	/**
	 * Test to print all the details
	 */
	//@Test
	public void logAllDetails(){
		//Ensure to have unique Email
		System.out.println("-----------------  Print all the Details -----------------------");
		
		//Creating a Student Object 
		ArrayList<String> courses = new ArrayList<String>();
			courses.add("Ruby");courses.add("C++");
		StudentPOJO student = new StudentPOJO();
			student.setFirstName("Petty");
			student.setLastName("SUR");
			student.setProgramme("Computer Science");
			student.setEmail("petSur2@mail.com"); 
			student.setCourses(courses);
		//Post the Request 
		given()
			.contentType(ContentType.JSON)
			.log().all()
		.when()
			.body(student)
			.post()
		.then()
			.statusCode(201);
		
	}
	
	/**
	 * Log only if the test fails
	 */
	@Test
	public void logOnFailure(){
		//Ensure to have unique Email
		System.out.println("-----------------  Print if validation failure -----------------------");
		
		//Creating a Student Object 
		ArrayList<String> courses = new ArrayList<String>();
			courses.add("Ruby");courses.add("C++");
		StudentPOJO student = new StudentPOJO();
			student.setFirstName("Petty");
			student.setLastName("SUR");
			student.setProgramme("Computer Science");
			student.setEmail("petSur3@mail.com"); 
			student.setCourses(courses);
		//Post the Request 
		given()
			.contentType(ContentType.JSON)
			.log().ifValidationFails()
		.when()
			.body(student)
			.post()
		.then()
			.statusCode(201);
		
	}
}
