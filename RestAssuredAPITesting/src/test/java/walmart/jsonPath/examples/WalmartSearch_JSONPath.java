package walmart.jsonPath.examples;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.internal.ValidatableResponseImpl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.path.json.JsonPath.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class WalmartSearch_JSONPath {
	static final String APIKEY = "6amstmtpeqw4yrbh4j6zrf26";

	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
	}

	//Extract numItems
	//@Test
	public void test001(){
		int numItems =	given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("numItems");

		System.out.println("-----------------------------------------------");
		System.out.println("The total number of Items are: "+ numItems);
		System.out.println("-----------------------------------------------");
	}
	//Extract Query
	//@Test
	public void test002(){
		String queryVal=	given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("query");

		System.out.println("-----------------------------------------------");
		System.out.println("The Search Query is: "+ queryVal);
		System.out.println("-----------------------------------------------");
	}

	//Extract First item in the Array
	//@Test
	public void test003(){
		String productName =	given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("items[0].name");

		System.out.println("-----------------------------------------------");
		System.out.println("The 1st Product in the Array is: " + productName);
		System.out.println("-----------------------------------------------");
	}

	//Extract HashMap(i.e. JSON Object) in a Array
	//@Test
	public void test004(){
		HashMap<String, Boolean> giftOptions =
				given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("items[0].giftOptions");

		System.out.println("-----------------------------------------------");
		System.out.println("Gift Option which is a HashMap in the Array: " + giftOptions);
		System.out.println("-----------------------------------------------");
	}

	//Size of Array List
	//@Test
	public void test005(){
		int size =
				given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("items.size()");

		System.out.println("-----------------------------------------------");
		System.out.println("Size of the Array list: " + size);
		System.out.println("-----------------------------------------------");
	}

	//Extract all the "names" in the "Items" Array List
	//@Test
	public void test006(){
		ArrayList<String> allNames =
				given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("items.name");

		System.out.println("-----------------------------------------------");
		System.out.println("Extract All Names: "+ allNames);
		System.out.println("-----------------------------------------------");
	}

	//Extract a entire JSON Object that has name="Apple iPod touch 128GB"  as a List<HashMap<String,Object>>
	//@Test
	public void test007(){
		ArrayList<HashMap<String, Object>> allItems =
				given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("items.findAll{it.name=='Apple iPod touch 128GB'}");

		System.out.println("-----------------------------------------------");
		System.out.println("Entire Json Object as List<HashMap<String,Object>>: "+ allItems);
		System.out.println("-----------------------------------------------");
	}

	//Extract all the sale price values for a product where [name == 'Apple iPod touch 32GB']
	//This is Similar to the previous example test007 but here we will be extracting the sale price values
	//@Test
	public void test008(){
		ArrayList<Float> salePriceValues =
				given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("items.findAll{it.name=='Apple iPod touch 32GB'}.salePrice");

		System.out.println("-----------------------------------------------");
		System.out.println("Sale Price of all the products where\n name == 'Apple iPod touch 32GB' : \n"+ salePriceValues);
		System.out.println("-----------------------------------------------");
	}

	//Extract all the sale price values for a product where [name.contains('Apple iPod')]
	//@Test
	public void test009(){
		ArrayList<Float> salePriceValues =
				given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("items.findAll{it.name.contains('Apple iPod')}.salePrice");

		System.out.println("-----------------------------------------------");
		System.out.println("Sale Price of all the products where \nname.contains('Apple iPod'):\n "+ salePriceValues);
		System.out.println("-----------------------------------------------");
	}
	//Extract all the names where [price < 150]
	//@Test
	public void test0010(){
		ArrayList<String> names =
				given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("items.findAll{it.salePrice<155}.name");

		System.out.println("-----------------------------------------------");
		System.out.println("Name of products whose salePrice is less than 155:\n "+ names);
		System.out.println("-----------------------------------------------");
	}
	//Extract msrp of items that STARTS with name=Ref
	//@Test
	public void test0011(){	
		ArrayList<String> msrp =
				given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("items.findAll{it.name==~/Ref.*/}.msrp");

		System.out.println("-----------------------------------------------");
		System.out.println("msrp values of items whose name starts with Ref:\n "+ msrp);
		System.out.println("-----------------------------------------------");
	}

	//Extract salePrice of items whose name ENDS WITH ed
		//@Test
	public void test0012(){	
		ArrayList<String> salePrice =
				given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("items.findAll{it.name==~/.*ed/}.salePrice");

		System.out.println("-----------------------------------------------");
		System.out.println("salePrice values of items whose name ends with ed:\n "+ salePrice);
		System.out.println("-----------------------------------------------");
	}


	//Using "with" you can extract the data as List,Map,Boolean,.....
	//Example to print the names of all the products as a list
	//@Test
	public void test0013(){	

		String json =	given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search")
				.asString();
		//We need static import of the with method import static io.restassured.path.json.JsonPath.*;
		List<String> names = with(json).getList("items.name");
		
		System.out.println("-----------------------------------------------");
		System.out.println("salePrice values of items whose name ends with ed:\n "+ names);
		System.out.println("-----------------------------------------------");
	}
	
	
		//
		//@Test
		public void test0014(){	

				Response response =given()
					.queryParam("query", "ipod")
					.queryParam("apiKey", APIKEY)
					.queryParam("format", "json")
					.when()
					.get("/search");
			//We need static import of the with method import static io.restassured.path.json.JsonPath.*;
			
				response
				.then()
				.body("numItems", equalTo(12));
			
			//Using JsonPath
				JsonPath.from(response.asString()).getList("");
				
			System.out.println("-----------------------------------------------");
			System.out.println("salePrice values of items whose name ends with ed:\n ");
			System.out.println("-----------------------------------------------");
		}
}
