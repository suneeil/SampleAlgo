package walmart.jsonPath.examples;


import java.util.List;

import io.restassured.RestAssured;
import io.restassured.internal.path.xml.NodeChildrenImpl;

import org.testng.annotations.BeforeClass;

import static io.restassured.path.xml.XmlPath.*;
import static io.restassured.RestAssured.given;

public class ExtractXMLResponse {
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
				.queryParam("format", "xml")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("searchresponse.numItems");

		System.out.println("-----------------------------------------------");
		System.out.println("The total number of Items are: "+ numItems);
		System.out.println("-----------------------------------------------");
	}


	//Extract first product Name by providing the list index
	//@Test
	public void test002(){
		String productName =	given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "xml")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("searchresponse.items.item[0].name");

		System.out.println("-----------------------------------------------");
		System.out.println("The product name is : "+ productName);
		System.out.println("-----------------------------------------------");
	}

	//Get the gift options for the firstproduct
	//@Test
	public void test003(){
		String xml =	given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "xml")
				.when()
				.get("/search")
				.asString();

		//We need static import of the with method import static io.restassured.path.xml.XmlPath.*;
		String giftOptions = with(xml).getString("searchresponse.items.item[0].giftOptions");
		System.out.println("-----------------------------------------------");
		System.out.println("The gift options under first product is : "+ giftOptions); // o/p: falsefalsefalse
		System.out.println("-----------------------------------------------");
	}

	//Count number of nodes
	//@Test
	public void test004(){
		NodeChildrenImpl val =	given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "xml")
				.when()
				.get("/search")
				.then()
				.extract()
				.path("searchresponse.items.item");

		System.out.println("-----------------------------------------------");
		System.out.println("The size of the items are : "+ val.size()); // o/p: 10
		System.out.println("-----------------------------------------------");
	}

	//Extract all names 
	//@Test
	public void test005(){
		String xml =	given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "xml")
				.when()
				.get("/search")
				.asString();

		//We need static import of the with method import static io.restassured.path.xml.XmlPath.*;
		List<String> names = with(xml).getList("searchresponse.items.item.name");

		System.out.println("-----------------------------------------------");
		System.out.println("All Names : " + names); 
		System.out.println("-----------------------------------------------");
	}
	
	//Extract the sale price for Name==Apple iPod touch 32GB 
		//@Test
		public void test006(){
			String xml =	given()
					.queryParam("query", "ipod")
					.queryParam("apiKey", APIKEY)
					.queryParam("format", "xml")
					.when()
					.get("/search")
					.asString();

			//We need static import of the with method import static io.restassured.path.xml.XmlPath.*;
			List<String> salePrice = with(xml).getList("searchresponse.items.item.findAll{it.name=='Apple iPod touch 32GB'}.salePrice");

			System.out.println("-----------------------------------------------");
			System.out.println("All Names : " + salePrice); 
			System.out.println("-----------------------------------------------");
		}
		
		//Deep Search in XML path  **.findAll{it.name=='Apple'}
				//@Test
				public void test007(){
					String xml =	given()
							.queryParam("query", "ipod")
							.queryParam("apiKey", APIKEY)
							.queryParam("format", "xml")
							.when()
							.get("/search")
							.asString();

					//We need static import of the with method import static io.restassured.path.xml.XmlPath.*;
					List<String> salePrice = with(xml).getList("**.findAll{it.name=='Apple iPod touch 32GB'}.salePrice");

					System.out.println("-----------------------------------------------");
					System.out.println("All Names : " + salePrice); 
					System.out.println("-----------------------------------------------");
				}
		
}
