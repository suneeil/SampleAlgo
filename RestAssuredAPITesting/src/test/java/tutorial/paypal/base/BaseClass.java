package tutorial.paypal.base;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;



public class BaseClass {

	public static String accessToken;
	public static final String clientID = "AVaK5R5ErU1hLsRx5Qw2Vfrt0jsqmUEMreWI5fWANDIbvgsrASzLAXv_kRtdOKJNYcvhRxHcBy4vywrY";
	public static final String clientSecret = "EHdT2ReDqfjJ1YRXoBAteSWpc2RQX99Ps649oanNLFy6Jx4m-x4wMyDq1aofbcpHs4y9I9Q7uikN8LDk";
	
	@BeforeClass
	public static void init(){
		System.out.println(">>>> @BeforeClass");
		RestAssured.baseURI = "https://api.sandbox.paypal.com";
		RestAssured.basePath = "/v1";
		
		accessToken = given()
		.params("grant_type", "client_credentials")
			.auth()
			.preemptive()
			.basic(clientID, clientSecret)
			.when()
			.post("/oauth2/token")
			.then()
			.log().all()
			.extract()
			.path("access_token");
		
		System.out.println("Access Token: "+ accessToken);
			
	}
	
	@BeforeTest
	public void bfTest(){
		System.out.println(">>>> @BeforeTest");
	}
	
}
