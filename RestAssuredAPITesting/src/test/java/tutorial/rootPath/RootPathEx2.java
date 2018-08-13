package tutorial.rootPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import io.restassured.RestAssured;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RootPathEx2 {
	static final String APIKEY = "6amstmtpeqw4yrbh4j6zrf26";
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
		RestAssured.rootPath = "items[1].giftOptions"; //<--------PROVIDING THE ROOT PATH FOR ALL TESTS
	}
	@AfterClass
	public void reset(){
		RestAssured.reset();
	}
	
	
	//If All my test case focuses only under a JSON object we can declare the RootPath in a
	//different way as well, say we need to verify allowGiftWrap, allowGiftMessage, allowGiftReceipt
	/**
	 *  	items[0]{
	 *  				"giftOptions": {
                				"allowGiftWrap": false,
                				"allowGiftMessage": false,
                				"allowGiftReceipt": false
            				}
            		}		
	 */
	//to verify allowGiftMessage  under items[1].giftOptions has false value
	@Test
	public void test001(){
		
		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()			
		.body("allowGiftMessage", equalTo(false))
		.statusCode(200);

	}
	//to verify allowGiftReceipt  under items[1].giftOptions has false value
	@Test
	public void test002(){
		
		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()			
		.body("allowGiftReceipt", equalTo(false))	
		.statusCode(200);

	}
	//to verify allowGiftWrap  under items[1].giftOptions has false value
	@Test
	public void test003(){
		
		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()			
		
		.body("allowGiftWrap", equalTo(false))	
		.statusCode(200);

	}
}
