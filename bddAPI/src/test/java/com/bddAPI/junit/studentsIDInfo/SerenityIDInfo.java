package com.bddAPI.junit.studentsIDInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import io.restassured.RestAssured;
import net.bytebuddy.implementation.bytecode.Throw;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)  //To run this test using Serenity use @RunWith(SerenityRunner.class)
//And run as Junit Test
public class SerenityIDInfo {
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI = System.getProperty("base.uri").toString();//"http://localhost:8085/student";
		
	}
	
	
	@Test
	public void getAllStudents(){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+System.getProperty("base.uri")+" <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		SerenityRest.given()
			.when()
			.get("/list")
			.then()
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void thisIsAFailingTest(){
	
		SerenityRest.given()
			.when()
			.get("/list")
			.then()
			.log().all()
			.statusCode(400);
	}
	
	@Pending
	@Test
	public void thisIsAPendingTest(){
		
	}
	
	@Ignore
	@Test
	public void thisTestIsSkipped(){
		
	}
	
	@Test
	public void thisTestHasError(){
		System.out.println("Divid by Zero: "+(1/0));
	}
	
	@Test
	public void fileDoesNotExist() throws FileNotFoundException{
		File file = new File("D:\\sample.txt");
		FileReader fr = new FileReader(file);
	}
	
	@Manual
	@Test
	public void needsManualTestExecution() {
		System.out.println("Execute the tests Manually ");
	}
}
