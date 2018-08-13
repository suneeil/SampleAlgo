package com.org.APITest;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.jayway.restassured.http.ContentType;
import io.restassured.http.ContentType;
//import com.jayway.restassured.response.Response;
import io.restassured.response.Response;

//import static com.jayway.restassured.RestAssured.*; //Creating a Static import so that we dont have to create a Object for it
import static io.restassured.RestAssured.*; //Creating a Static import so that we dont have to create a Object for it
public class WeatherGetRequest {

	@Test
	public void test_01(){
		Response resp = when().
				get("http://api.openweathermap.org/data/2.5/weather?q=Bangalore&appid=25d99ca0098771eaedcea01b129faf35");

		System.out.println("Status Code: "+ resp.getStatusCode());
		System.out.println(resp.getBody().prettyPrint());
		Assert.assertEquals(resp.getStatusCode(), 200);	
	}
	//How to use parameters with Rest Assured
	//@Test
	public void test_02(){
		//?q=Bangalore&appid=25d99ca0098771eaedcea01b129faf35
		Response resp = given().
				param("q", "Bangalore").
				param("appid", "25d99ca0098771eaedcea01b129faf35").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");

		System.out.println("Status Code: "+ resp.getStatusCode());
		System.out.println(resp.getBody().prettyPrint());
		Assert.assertEquals(resp.getStatusCode(), 200);

	}

	//Using withing the assert with the given when then 
	//@Test
	public void test_03(){
		//?q=Bangalore&appid=25d99ca0098771eaedcea01b129faf35
		given().
		param("q", "Bangalore").
		param("appid", "25d99ca0098771eaedcea01b129faf35").
		when().
		get("http://api.openweathermap.org/data/2.5/weather").
		then().
		assertThat().statusCode(200);
	}
	//Collect all the respose
	//@Test
	public void test_04(){
		//?q=Bangalore&appid=25d99ca0098771eaedcea01b129faf35
		Response resp = given().
		param("q", "Bangalore").
		param("appid", "25d99ca0098771eaedcea01b129faf35").
		when().
		get("http://api.openweathermap.org/data/2.5/weather");
		System.out.println(resp.asString());
	}
	 
	//Collect all the respose
		//	@Test
		public void test_05(){
			//?q=Bangalore&appid=25d99ca0098771eaedcea01b129faf35
			Response resp = given().
							param("q", "Bangalore").
							param("appid", "25d99ca0098771eaedcea01b129faf35").
							when().get("http://api.openweathermap.org/data/2.5/weather");
			System.out.println(resp.toString());
		}
	 

	//@Test
	public void test_06(){
		//?q=Bangalore&appid=25d99ca0098771eaedcea01b129faf35
		Response resp =			given().
								param("id", "2172797").
								param("appid", "25d99ca0098771eaedcea01b129faf35").
								when().
								get("http://api.openweathermap.org/data/2.5/weather");

		String	weatherReport =	resp.
								then().
								contentType(ContentType.JSON).
								extract().path("weather[0].description");

		System.out.println("Weather Report description: "+ weatherReport);

	}

	//@Test
	public void test_07(){
		//?q=Bangalore&appid=25d99ca0098771eaedcea01b129faf35
		Response resp =			given().param("id", "2172797").param("appid", "25d99ca0098771eaedcea01b129faf35").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");

		String	weatherReport =	resp.
				then().
				contentType(ContentType.JSON).
				extract().path("weather[0].description");

		System.out.println("Weather Report description by id: "+ weatherReport);


		String lon = resp.
				then().
				extract().
				path("coord.lon").toString();
		String lat = resp.
				then().
				extract().
				path("coord.lat").toString();
		System.out.println("Longitute: " + lon);
		System.out.println("Latitute: " + lat);

		//-------- Using the lat and lon we will again hit the API
		Response respByCoordinates =	given().
										param("lat", lat).
										param("lon", lon).
										param("appid", "25d99ca0098771eaedcea01b129faf35").
										when().
										get("http://api.openweathermap.org/data/2.5/weather");

		String	weatherReport1 =	respByCoordinates.
									then().
									contentType(ContentType.JSON).
									extract().path("weather[0].description");
		System.out.println("Weather desc by Coordinates: " + weatherReport1);


	}
}
