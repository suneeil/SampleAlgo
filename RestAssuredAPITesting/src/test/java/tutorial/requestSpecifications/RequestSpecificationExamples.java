package tutorial.requestSpecifications;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RequestSpecificationExamples {

	//Using Request Specification we can minimize repetitive code 
	//The RequestSpecBuilder provides differnt methods to build our initial Request
	//Like "Add Query parameters", "Add Content Type"
	
	//Step 1: Create a RequestSpecBuilder
	//Step 2: Then create RequestSpecification obj using RequestSpecBuilder
	
	static final String APIKEY = "6amstmtpeqw4yrbh4j6zrf26";
	static RequestSpecBuilder requestBuilder;
	static RequestSpecification requestSpecificatoion;

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
		
		requestBuilder = new RequestSpecBuilder();
		//Building Query Parameter 
		requestBuilder.addQueryParam("query", "ipod");
		requestBuilder.addQueryParam("apiKey", APIKEY);
		requestBuilder.addQueryParam("format", "json");
		requestBuilder.addQueryParam("facet","on");
		//Building Header 
		requestBuilder.addHeader("Accept", "*/*");
		
		requestSpecificatoion = requestBuilder.build(); //Create a 
		
//		requestBuilder.addCookie("");
//		requestBuilder.setProxy("HOST", 80, "SCHEME");
//		requestBuilder.setPort(80);
//		requestBuilder.setBody("");
//		requestBuilder.addMultiPart("", "");
		//requestBuilder.setAuth(AuthenticationScheme);
	}

	@Test
	public void test001(){

		given()
		.spec(requestSpecificatoion) // <------------- Setting the Request specification
		.log().all()
		.when()
		.get("/search")
		.then()			
		.statusCode(200);
		

	}
}
