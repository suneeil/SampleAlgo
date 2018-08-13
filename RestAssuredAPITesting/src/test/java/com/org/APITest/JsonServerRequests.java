package com.org.APITest;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import com.org.APIClasses.Info;
import com.org.APIClasses.MyPostClass;
import com.org.APIClasses._Posts;
import com.org.APIClasses.advancedExample.InfoArr;
import com.org.APIClasses.advancedExample.PostInfoArray;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*; //Creating a Static import so that we dont have to create a Object for it

public class JsonServerRequests {
	/**
	 * To run the tests in the class ensure to run the below command from the command prompt
	 * json-server --watch db.json and also ensure to have a file db.json in the desktop
	 */
	//Get request
	//@Test
	public void test_01(){
		Response resp = given().
				when().
				get("http://localhost:3000/posts");

		System.out.println("Get Response:\n "+resp.asString());

	}
	//Post Request, But the below process is not the right way since handling post body as String is tedious
	//@Test
	public void test_02(){
		Response resp = given().
				body("{\"id\":\"2\",\"title\":\"MY TITLE\",\"author\":\"Sunil Rao\"}").
				when().
				contentType(ContentType.JSON).
				post("http://localhost:3000/posts");
		System.out.println("Get Response:\n "+resp.asString());

	}
	//Post Request, Send the post requst body in Object form
	//	@Test
	public void test_03(){
		MyPostClass mypostclass = new MyPostClass();
		mypostclass.setId("4");
		mypostclass.setAuthor("RaoG");
		mypostclass.setTitle("Apache Tutor");

		Response resp = given().
				when().
				contentType(ContentType.JSON).
				body(mypostclass).
				post("http://localhost:3000/posts");
		System.out.println("Get Status Code: "+resp.getStatusCode());
		System.out.println("Get Response:\n "+resp.asString());
	}
	//Put Request, To update the existing Data and Send the post requst body in Object form
	// Note to update Send the existing ID and 
	//in the put URL ensure to pass the same ID
	//@Test
	public void test_04(){
		MyPostClass mypostclass = new MyPostClass();
		mypostclass.setId("4");
		mypostclass.setAuthor("updt-Sunil G Rao");
		mypostclass.setTitle("updt-Java Tutorials");
		Response resp = given().
				when().
				contentType(ContentType.JSON).
				body(mypostclass).
				put("http://localhost:3000/posts/4");
		System.out.println("Get Status Code: "+resp.getStatusCode());
		System.out.println("Get Response:\n "+resp.asString());
	}
	//Patch Request, to do a update Instead of sending all the data again as in POST. 
	//Use PATCH to just send necessary field to get updated
	// Note to update Send the existing ID and 
	//in the put URL ensure to pass the same ID
	//	@Test
	public void test_05(){
		//NOTE: If you are updating only one value make use of String
		//NOTE: If you need to updated multiple data then use a Object
		/*MyPostClass mypostclass = new MyPostClass();
					mypostclass.setId("4");
					mypostclass.setAuthor("updt-Sunil G Rao");
					mypostclass.setTitle("updt-Java Tutorials");*/
		Response resp = given().
				when().
				contentType(ContentType.JSON).
				body("{\"title\":\"Shirdi Sai\"}").
				patch("http://localhost:3000/posts/2");
		System.out.println("Get Status Code: "+resp.getStatusCode());
		System.out.println("Get Response:\n "+resp.asString());
	}
	//Delete /posts/1
	//@Test
	public void test_06(){
		Response resp = given().when().delete("http://localhost:3000/posts/4");
		System.out.println("Get Status Code: "+resp.getStatusCode());
		System.out.println("Get Response:\n "+resp.asString());
		System.out.println(resp.getHeader(basePath));
	}
	//Complex POST example
	//@Test
	public void test_07(){
		Info info = new Info();
		info.setAddress("#39, 4th Block, Bangalore");
		info.setEmail("sunil@rao.com");
		info.setPhone("6554333333");
		_Posts posts= new _Posts();
		posts.setId("4");
		posts.setAuthor("Sunil G Rao");
		posts.setTitle("Java Tutorials");
		posts.setInfo(info);
		Response resp = given().
				when().
				contentType(ContentType.JSON).
				body(posts).
				post("http://localhost:3000/posts");

		System.out.println("Get Status Code: "+resp.getStatusCode());
		System.out.println("Get Response:\n "+resp.asString());
		System.out.println(resp.getHeaders());
	}
	//Change the postinfoArr.setId("101"); to some other num
	//@Test
	public void test_08(){
		InfoArr infoarr1 = new InfoArr();
		infoarr1.setAddress("Patna");
		infoarr1.setEmail("pat@na.com");
		infoarr1.setPhone("7777777777");
		InfoArr infoarr2 = new InfoArr();
		infoarr2.setAddress("kolkata");
		infoarr2.setEmail("kol@kata.com");
		infoarr2.setPhone("8888888888");
		PostInfoArray postinfoArr= new PostInfoArray();
		postinfoArr.setId("102");
		postinfoArr.setAuthor("Sai Ram");
		postinfoArr.setTitle("Groovy");
		postinfoArr.setInfoArr(new InfoArr[]{infoarr1,infoarr2});
		Response resp = given().
				when().
				contentType(ContentType.JSON).
				body(postinfoArr).
				post("http://localhost:3000/posts");
		System.out.println("Get Status Code: "+resp.getStatusCode());
		System.out.println("Get Response:\n "+resp.asString());
		System.out.println(resp.getHeaders());
	}
	//Capture or Assert the response time
	@Test
	public void test_09(){
		Response resp = given().
				when().
				get("http://localhost:3000/posts");
		System.out.println("RESP.Time: "+ resp.time());
		Long time = resp.then().extract().time();
		System.out.println("Extract Response Time: "+ time);
		//Using hamcrest we can lessthan greater than methods ---> import static org.hamcrest.Matchers.*;
		//This will fail the test if the response time is less than 700 mil seconds
		given().
		when().
		get("http://localhost:3000/posts").
		then().
		and().
		time(lessThan(700L));
	}
}
