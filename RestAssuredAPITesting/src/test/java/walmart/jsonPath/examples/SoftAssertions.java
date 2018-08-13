package walmart.jsonPath.examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.instanceOf;
import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SoftAssertions {
	static final String APIKEY = "6amstmtpeqw4yrbh4j6zrf26";
	@Test(description="Note: This Test will Fail as")
	public void softAssertTest(){

		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name", "Apple iPod touch 128GBB")),
				"items[1].giftOptions", hasKey("allowGiftWrap"),
				"items[1].giftOptions", hasValue(true),
				"query", instanceOf(String.class));

	}

	@Test(description="Note: This Test will Fail as")
	public void hardAssertTest(){

		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()
		.body("items.findAll{it.name=='Apple iPod touch 128GB'}", hasItems(hasEntry("name", "Apple iPod touch 128GBB")))
		.body("items[1].giftOptions", hasKey("allowGiftWrap"))
		.body("items[1].giftOptions", hasValue(true))
		.body("query", instanceOf(String.class));
		//.body(hasItems(hasEntry("name", "Apple iPod touch 128GBB")));
		
		/*
				"items[1].giftOptions", hasKey("allowGiftWrap"),
				"items[1].giftOptions", hasValue(true),
				"query", instanceOf(String.class));
*/
	}
	
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
	}
}
