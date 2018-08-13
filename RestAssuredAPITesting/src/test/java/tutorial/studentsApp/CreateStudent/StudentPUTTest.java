package tutorial.studentsApp.CreateStudent;
import static org.hamcrest.Matchers.*; //For validating the response
import static io.restassured.RestAssured.*;  //For calling the given() directly

import java.util.ArrayList;

import io.restassured.RestAssured; //Import For baseURI,PORT,basePath
import io.restassured.http.ContentType;
import io.restassured.response.Response; //To handle Response

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tutorial.studentsApp.CreateStudent.pojoClasses.StudentPOJO;
import tutorial.studentsApp.base.TestBase;

public class StudentPUTTest extends TestBase{
		
	@Test
	public void updateStudent(){
		//Ensure to have unique Email
		ArrayList<String> courses = new ArrayList<String>();
			courses.add("Python");courses.add("Java");courses.add("Groovy");
		
		StudentPOJO student = new StudentPOJO();
			student.setFirstName("Sunil");
			student.setLastName("G Rao");
			student.setProgramme("Computer Science");
			student.setEmail("sun1@rao.com"); 
			student.setCourses(courses);
		
		given()
			.contentType(ContentType.JSON)
		.when()
			.body(student)
			.put("/106")
		.then().log().all()
			.statusCode(200);
		
	}
}
