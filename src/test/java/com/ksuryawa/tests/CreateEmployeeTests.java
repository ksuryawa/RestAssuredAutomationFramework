package com.ksuryawa.tests;

import com.ksuryawa.annotations.FrameworkAnnotations;
import com.ksuryawa.constants.FrameworkConstants;
import com.ksuryawa.pojo.Employee;
import com.ksuryawa.reports.ExtentLogger;
import com.ksuryawa.requestbuilder.RequestBuilder;
import com.ksuryawa.utils.ApiUtils;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.io.File;

import static com.ksuryawa.utils.RandomUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateEmployeeTests {

	@Test(description = "Create an Employee using POJO builder")
	@FrameworkAnnotations
	public void createEmployee() {

		Employee employee = Employee.builder()
				.setId(getId())
				.setFirstName(getFirstName())
				.setLastName(getLastName())
				.setEmail(getEmail())
				.build();

		RequestSpecification requestSpecification = RequestBuilder
				.buildRequestForPostCalls()
				.body(employee);

		ExtentLogger.logRequest(requestSpecification);
		Response response = requestSpecification.post("/employees");

		response.prettyPrint();

		ExtentLogger.logResponse(response.asPrettyString());


		assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
		assertThat(response.time()).isLessThan(1000);

		ApiUtils.storeStringAsJson(FrameworkConstants.getResponseJsonFilePath(), response);


	}

	@Test(description = "Create an Employee using External file")
	@FrameworkAnnotations
	public void createEmployeeUsingExternalFile() {

		String resource = ApiUtils.readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath() + "request.json")
				.replace("Id", String.valueOf(getId()))
				.replace("fname", getFirstName())
				.replace("lname", getLastName())
				.replace("emailId", getEmail());

		RequestSpecification requestSpecification = RequestBuilder
				.buildRequestForPostCalls()
				.body(resource);

		ExtentLogger.logRequest(requestSpecification);
		Response response = requestSpecification.post("/employees");

		response.prettyPrint();

		ExtentLogger.logResponse(response.asPrettyString());

		assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
		assertThat(response.time()).isLessThan(1000);

		ApiUtils.storeStringAsJson(FrameworkConstants.getResponseJsonFilePath(), response);

		validateJsonSchema(response);


	}

	private void validateJsonSchema(Response response) {
		response.then().body(JsonSchemaValidator.matchesJsonSchema(new File(FrameworkConstants.getSchemaValidationJsonFilePath())));
	}
}