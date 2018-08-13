package com.org.APITest;
import java.util.Map;

import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*; //Creating a Static import so that we dont have to create a Object for it

public class GetHeadersAndCookies {
	/**
	 * Get response Headers
	 */
	//@Test
	public void testResponseHeaders(){
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		//To get single Header
		String headerCFRY = response.header("CF-RAY");
		System.out.println(">>>>>> Header: "+ headerCFRY);
		System.out.println("");
		//to get all headers
		Headers headers = response.headers();
		for(Header h : headers)
			System.out.println(h.getName()+ " : " + h.getValue());
	}

	/**
	 * To get cookies
	 */
	//@Test
	public void testGetCookies(){
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		Map<String, String> cookies = response.getCookies();
		for(Map.Entry<String, String> entry : cookies.entrySet())
			System.out.println(entry.getKey() + " : " + entry.getValue());
	}

	/**
	 * To test the cookie in detail
	 */
	@Test
	public void testCookiesInDetail(){
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		Cookie cookie = response.getDetailedCookie("__cfduid"); //"__cfduid" was got from the testGetCookies method
		System.out.println(cookie.hasExpiryDate());
		System.out.println(cookie.getExpiryDate());
		System.out.println(cookie.hasValue());
	}
}
