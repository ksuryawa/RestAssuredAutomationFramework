package com.ksuryawa.tests;

import com.ksuryawa.annotations.FrameworkAnnotations;
import com.ksuryawa.reports.ExtentLogger;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class ReqResTest {

	@Test(description = "Get ReqRes test from id")
	@FrameworkAnnotations
	public void getReqresTest() {
		Response response = given()
				.log()
				.all()
				.pathParam("id", 2)
				.get("https://reqres.in/api/users/{id}");

		ExtentLogger.logResponse(response.asPrettyString());

		response.prettyPrint();
		System.out.println(response.statusCode());

		assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);

	}
}