package tutorial.responseSpecifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResponseSpecificationEx {
	static final String APIKEY = "6amstmtpeqw4yrbh4j6zrf26";
	static ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpecification;	
	static RequestSpecBuilder requestBuilder;
	static RequestSpecification requestSpecificatoion;
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
		//----------------------------  Creating Request ---------------------------- 
		requestBuilder = new RequestSpecBuilder();
		//Building Query Parameter 
		requestBuilder.addQueryParam("query", "ipod");
		requestBuilder.addQueryParam("apiKey", APIKEY);
		requestBuilder.addQueryParam("format", "json");
		requestBuilder.addQueryParam("facet","on");
		//Building Header 
		requestBuilder.addHeader("Accept", "*/*");
		requestSpecificatoion = requestBuilder.build(); //Create a 
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
		responseSpecification = responseBuilder.build();
	}
	@Test
	public void test001(){
		given()
		.spec(requestSpecificatoion) // <------------- Setting the Request specification
		.log().all()
		.when()
		.get("/search")
		.then()		
		.spec(responseSpecification) // <-------------  Setting the Response Specification
		.statusCode(200);
	}
	
	@Test
	public void test002(){
		Response resp = given()
		.spec(requestSpecificatoion) // <------------- Setting the Request specification
		.log().all()
		.when()
		.get("/search");		
		System.out.println(resp.getBody().asString());
	}
}
