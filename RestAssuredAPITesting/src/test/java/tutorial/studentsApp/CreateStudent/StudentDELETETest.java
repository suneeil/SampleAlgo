package tutorial.studentsApp.CreateStudent;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import tutorial.studentsApp.base.TestBase;

public class StudentDELETETest extends TestBase{
	
	/**
	 * We Use patch method if we want just one object to be changes
	 */
	@Test
	public void deleteStudent(){
		
		given()
		.when()
			.delete("/104")
		.then().log().all()
			.statusCode(204);
		
	}
}
