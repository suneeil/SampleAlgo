package tutorial.studentsApp.CreateStudent;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.ArrayList;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tutorial.studentsApp.CreateStudent.pojoClasses.StudentPOJO;
import tutorial.studentsApp.base.TestBase;

public class StudentPATCHTest extends TestBase{
	
	
	/**
	 * We Use patch method if we want just one object to be changes
	 */
	@Test
	public void patchStudent(){
		StudentPOJO student = new StudentPOJO();
			student.setEmail("suni1rao@rao.com"); 
		
		given()
			.contentType(ContentType.JSON)
		.when()
			.body(student)
			.patch("/106")
		.then().log().all()
			.statusCode(200);
		
	}
}
