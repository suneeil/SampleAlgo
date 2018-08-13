package tutorial.compareJSONs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class CompareJSONTest {

	//@Test
	public void test001(){
		try{
			String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
			String actual   = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"lion\",\"bird\"]}],pets:[]}";
			JSONAssert.assertEquals(expected, actual, false);
		}catch(JSONException e){
			System.out.println(e.getMessage());
		}
	}
	//Using JSON compare in LENIENT
	//@Test
	public void test002(){
		try{
			String expected_Resopnse = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+
					"/src/test/java/tutorial/compareJSONs/response.txt")));
			String actual_Resopnse = given()
						.when()
						.get("http://localhost:8085/student/list")
						.asString();
			JSONAssert.assertEquals(expected_Resopnse, actual_Resopnse, JSONCompareMode.LENIENT);
			
			
		} catch (IOException e) {
			System.out.println("IO EXCEPTION:\n"+e.getMessage());
		} catch (JSONException e) {
			System.out.println("JSON EXCEPTION:\n"+e.getMessage());
		}
	}
	
	//Using JSON compare in STRICT
		@Test
		public void test003(){
			try{
				String expected_Resopnse = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+
						"/src/test/java/tutorial/compareJSONs/response2.txt")));
				String actual_Resopnse = given()
							.when()
							.get("http://localhost:8085/student/list")
							.asString();
				JSONAssert.assertEquals(expected_Resopnse, actual_Resopnse, JSONCompareMode.STRICT);
				
				
			} catch (IOException e) {
				System.out.println("IO EXCEPTION:\n"+e.getMessage());
			} catch (JSONException e) {
				System.out.println("JSON EXCEPTION:\n"+e.getMessage());
			}
		}
}
