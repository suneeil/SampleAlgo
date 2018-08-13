package com.selenium.Webdriver;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class CheckResponsCode {

	public static void main(String[] args) {
		
		getResponseCode("http://www.bing.com");
		getResponseCode("http://www.gmail.com");
		getResponseCode("http://192.168.51.66:8080/profile/justdial.com");
	}

	
	public static void getResponseCode(String url){
		try {
			StatusLine status = Request.Get(url).connectTimeout(300).execute().returnResponse().getStatusLine();
			System.out.println("Status Code: "+status.getStatusCode());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			System.out.println("ClientProtocolException");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
		}
		
		
	}
	
}
