package tutorial.responseTime;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResponseTimeEx {
	static final String APIKEY = "6amstmtpeqw4yrbh4j6zrf26";
	static ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpecification;
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
		
		//---------------------------- Response Spec Builder --------------------------------------------
				//Creating Response Spec Builder
				responseBuilder = new ResponseSpecBuilder();
				//Check Headers
				responseBuilder.expectHeader("content-type","application/json; charset=utf-8");
				responseBuilder.expectHeader("server","Mashery Proxy");
				//Check Status code
				responseBuilder.expectStatusCode(200);
				//Check a value in Json response
				responseBuilder.expectBody("query",equalTo("ipod")); //To use equalTo --> import static org.hamcrest.Matchers.equalTo;
				responseBuilder.expectBody("numItems",equalTo(10));
				responseBuilder.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
				responseSpecification = responseBuilder.build();
	}
	//Get Response time in milliseconds 
	@Test
	public void test001(){
		
		long respTime = given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search").time();
		
		System.out.println("Response Time: "+ respTime + " ms");
	}
	
	//Get Response time in Seconds
	@Test
	public void test002(){
		
		long respTime = given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search").timeIn(TimeUnit.SECONDS);
		
		System.out.println("Response Time: "+ respTime + " seconds");
	}
	
	//Add assertions to response time
		@Test
		public void test003(){
			
			given()
			.queryParam("query", "ipod")
			.queryParam("apiKey", APIKEY)
			.queryParam("format", "json")
			.when()
			.get("/search")
			.then()
			.time(lessThan(3L),TimeUnit.SECONDS); //Instead of verifying the response time each test we can add it in response spec builder
												//See the example below
			
			System.out.println("Done");
			
			
		}
		
		@Test
		public void test004(){
			
			given()
			.queryParam("query", "ipod")
			.queryParam("apiKey", APIKEY)
			.queryParam("format", "json")
			.when()
			.get("/search")
			.then()
			.spec(responseSpecification);
			
			System.out.println("Done");
			
			
		}
}
