package com.bddAPI.junit.studentsInfo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class DifferentTestOutcomes {
	@Test
	public void justSomeOtherTest(){
		SerenityRest.given()
		.when()
		.get("http://localhost:8085/student/list")
		.then()
		.log().all()
		.statusCode(200);
	}
}
