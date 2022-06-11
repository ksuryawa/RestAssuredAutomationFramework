package com.ksuryawa.tests;

import com.ksuryawa.requestbuilder.RequestBuilder;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetEmployeeTest {

	@Test
	public void getEmployees() {
		Response response = RequestBuilder
				.buildRequestForGetCalls()
				.get("/employees");

		response.prettyPrint();
		System.out.println(response.statusCode());

		assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);
		assertThat(response.jsonPath().getList("$")).isNotEmpty();

	}

	@Test
	public void getEmployee() {
		Response response = RequestBuilder
				.buildRequestForGetCalls()
				.pathParam("id", 1)
				.get("/employees/{id}");

		response.prettyPrint();
		System.out.println(response.statusCode());

		assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_OK);

	}

}