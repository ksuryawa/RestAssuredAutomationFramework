package com.ksuryawa.tests;

import com.ksuryawa.annotations.FrameworkAnnotations;
import com.ksuryawa.reports.ExtentLogger;
import com.ksuryawa.requestbuilder.RequestBuilder;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetEmployeeTests {

	@Test
	@FrameworkAnnotations
	public void getEmployees() {
		Response response = RequestBuilder
				.buildRequestForGetCalls()
				.get("/employees");

		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponse(String.valueOf(response.statusCode()));
		response.prettyPrint();
		System.out.println(response.statusCode());

		assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
		assertThat(response.jsonPath().getList("$")).isNotEmpty();

	}

	@Test(description = "Get employee details from id")
	@FrameworkAnnotations
	public void getEmployee() {
		Response response = RequestBuilder
				.buildRequestForGetCalls()
				.pathParam("id", 1)
				.get("/employees/{id}");

		ExtentLogger.logResponse(response.asPrettyString());

		response.prettyPrint();
		System.out.println(response.statusCode());

		assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);

	}

}