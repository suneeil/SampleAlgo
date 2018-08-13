package tutorial.rootPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.instanceOf;
import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RootPathEx {
	static final String APIKEY = "6amstmtpeqw4yrbh4j6zrf26";

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
	}
	
	@Test
	public void test001(){
		
		given()
		.queryParam("query", "ipod")
		.queryParam("apiKey", APIKEY)
		.queryParam("format", "json")
		.when()
		.get("/search")
		.then()			
		
		.root("items[1].giftOptions") //setting the root path
		
		.body("allowGiftMessage", equalTo(false))
		.body("allowGiftReceipt", equalTo(false))
		.body("allowGiftWrap", equalTo(false))
		
		.root("items[0].imageEntities")//setting the root path
		
		.body("entityType", hasItem("SECONDARY"))
		.statusCode(200);

	}
}
