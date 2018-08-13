package tutorial.studentsApp;

import static org.hamcrest.Matchers.*; //For validating the response
import static io.restassured.RestAssured.*;  //For calling the given() directly
import io.restassured.RestAssured; //Import For baseURI,PORT,basePath
import io.restassured.response.Response; //To handle Response


import org.testng.annotations.Test;

import tutorial.studentsApp.base.TestBase;
public class StudentGetTest extends TestBase{

	
	//@Test
	public void getAllStudentInformation(){
		Response response = given()
				.when()
				.get("/list");
		
		//Can use this to print the Response
				response.body().prettyPrint();
				//Or if you are using SYSO then 
				System.out.println("------------------------------------");
				System.out.println(response.asString());
		//Validate the status code
		given()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
		
		
	}

	//@Test
	public void retriveSingleStudentInfo(){
		Response response = given()
				.when()
				.get("/1");
		//Can use this to print the Response
		response.body().prettyPrint();
		//Or if you are using SYSO then 
		System.out.println("------------------------------------");
		System.out.println(response.asString());
	}
	//Get students who has enrolled in financial domain
	//@Test
	public void GetFinancialStudents(){
		Response response = given()
				.when()
				.get("/list?programme=Financial Analysis&limit=2");
		//Can use this to print the Response
		response.body().prettyPrint();
		//Or if you are using SYSO then 
		System.out.println("-------------- response.asString() ----------------------");
		System.out.println(response.asString());
		System.out.println("---------------- response.body().asString() --------------------");
		System.out.println(response.body().asString());
		
	}
	
	//Use PrettyPeak to print the response along with the Header
	//Get students who has enrolled in financial domain
		//@Test
		public void UsingPrettyPeak(){
			Response response = given()
					.when()
					.get("/list?programme=Financial Analysis&limit=2");
			//Can use this to print the Response
			response.body().prettyPrint();
			//Or if you are using SYSO then 
			System.out.println("---------------- response.prettyPeek() --------------------");
			System.out.println(response.prettyPeek());
		}
	
		//Pass parameters example
		//Get students who has enrolled in financial domain
		@Test
		public void passParametersEx(){
			Response response = given()
					.param("programme", "Financial Analysis")
					.param("limit", 1)
					.when()
					.get("/list");
			//Can use this to print the Response
			response.body().prettyPrint();
			
		}
		
}
