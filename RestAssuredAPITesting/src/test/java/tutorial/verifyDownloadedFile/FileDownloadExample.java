package tutorial.verifyDownloadedFile;

import io.restassured.RestAssured;

import java.io.File;
import java.nio.file.Paths;

import org.junit.Assert;
import org.testng.annotations.Test;

public class FileDownloadExample {

	//Download a file from https://github.com/mozilla/geckodriver/releases/download/v0.20.0/geckodriver-v0.20.0-arm7hf.tar.gz
	//Compare it with the existing file
	//Check the size of the file
	
	@Test
	public void verifyDownloadedFile(){
		//Paths.get(System.getProperty("user.dir")+"/src/test/java/tutorial/verifyDownloadedFile/geckodriver-v0.20.0-arm7hf.tar.gz"
		//2.71 MB
		
		//Read a File
		File inputFile = new File(System.getProperty("user.dir")+"/src/test/java/tutorial/verifyDownloadedFile/geckodriver-v0.20.0-arm7hf.tar.gz");
		
		//Length of input file
		int expectedSize = (int) inputFile.length();
		System.out.println("Expected file size: "+ expectedSize + " bytes");
		
		//Read Downloaded the file
		byte[] actualValue = RestAssured
		.given()
			.get("https://github.com/mozilla/geckodriver/releases/download/v0.20.0/geckodriver-v0.20.0-arm7hf.tar.gz")
		.then()
			.extract()
			.asByteArray();
		System.out.println("Actual File size: "+ actualValue.length + " bytes");
		
		Assert.assertEquals(expectedSize, actualValue.length);
	}
}
