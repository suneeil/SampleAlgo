package walmart.jsonPath.examples;


import static io.restassured.RestAssured.given;
//We need to statically import  import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class HamcrestMatcherExamples {

	static final String APIKEY = "6amstmtpeqw4yrbh4j6zrf26";

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
	}
	//Verify the number of items ==10
	//@Test
	public void test001(){
		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		.body("numItems", equalTo(10));
	}
	//Verify Query value in the json response
	//@Test
	public void test002(){
		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		.body("query", equalToIgnoringCase("ipod"));
	}

	//Check single Names in a List
	//@Test
	public void test003(){
		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		.body("items.name", hasItem("Apple iPod touch 128GB"));
	}
	//Check multiple Names in a List
	//	@Test
	public void test004(){
		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		.body("items.name", hasItems("Apple iPod touch 128GB","Apple iPod Touch 6th Generation 16GB Refurbished","Refurbished Apple iPod Touch 32GB, 5th Generation, Blue"));
	}

	//Check values inside a Map using hasKey() and hasValue()
	//@Test
	public void test005(){
		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		.body("items[1].giftOptions", hasKey("allowGiftWrap"))
		.body("items[1].giftOptions", hasValue(false));
	}

	//Check hashMap values inside a list i.e.  List<HashMap<String,Object>>  has a key=name with value=Apple iPod touch 128GB
	//@Test
	public void test006(){

		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name", "Apple iPod touch 128GB")));

	}
	//Add multiple Assertions 
	@Test
	public void test007(){

		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name", "Apple iPod touch 128GB")))
		.body("items[1].giftOptions", hasKey("allowGiftWrap"))
		.body("items[1].giftOptions", hasValue(false))
		.body("query", instanceOf(String.class))
		.statusCode(200);

	}

	//Logical Assertions 
	@Test
	public void test008(){

		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		.body("items.size()",greaterThan(5))
		.body("items.size()", lessThan(11))
		.body("items.size()", greaterThanOrEqualTo(10))
		.body("items.size()", lessThanOrEqualTo(10));

	}
}
