package tutorial.filterInRestAssured;

import java.io.PrintStream;
import java.io.StringWriter;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FilterExamples {
	static final String APIKEY = "6amstmtpeqw4yrbh4j6zrf26";
	//Variables to write Request
	public static StringWriter requestWriter;
	public static PrintStream requestCapture;
	//Variable to write Response
	public static StringWriter responseWriter;
	public static PrintStream responseCapture;
	//Variable to error write 
	public static StringWriter errorWriter;
	public static PrintStream errorCapture;
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = "http://api.walmartlabs.com";
		RestAssured.basePath = "/v1";
	}
	@BeforeMethod
	public void beforeEachTest(){
		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter, "UTF-8"), true);  //To Use "WriterOutputStream" class we need "Apache Commons IO"

		responseWriter = new StringWriter();
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter,"UTF-8"), true);

		errorWriter = new StringWriter();
		errorCapture = new PrintStream(new WriterOutputStream(errorWriter,"UTF-8"), true);
	}
	@Test
	public void test001(){

		String response = RestAssured.given()
				.queryParam("query", "ipod")
				.queryParam("apiKey", APIKEY)
				.queryParam("format", "json")
				.when()
				.get("/search").asString();
		System.out.println("DONE: "+ response);

		System.out.println("-----------FILTER Example-------------");
		RestAssured
		.given()
			.queryParam("query", "ipod")
			.queryParam("apiKey", APIKEY)
			.queryParam("format", "json")

				.filter(new RequestLoggingFilter(requestCapture)) //filter Used to capture the request
				.filter(new ResponseLoggingFilter(responseCapture)) //filter Used to capture the response
		.when()
		.get("/search");
		System.out.println("Request:\n"+requestWriter.toString()+"\n");    //  <---------- Can be used to print Request
		System.out.println("Response:\n"+responseWriter.toString());	   //  <---------- Can be used to print Response
		System.out.println("-----------------ERROR FILTER prints only on a failure------------------------");
		RestAssured
		.given()
			.queryParam("query", "ipod")
			.queryParam("apiKey", APIKEY)
			.queryParam("format", "json")
				.filter(new ErrorLoggingFilter(errorCapture)) //filter used to capture on a failure
		.when()
		.get("/searchADD");
		System.out.println("ERROR LOG:\n"+ errorWriter.toString());		//  <---------- Can be used to print Error
	}
}
