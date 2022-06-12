package com.ksuryawa.tests;

import com.ksuryawa.constants.FrameworkConstants;
import com.ksuryawa.pojo.Employee;
import com.ksuryawa.requestbuilder.RequestBuilder;
import com.ksuryawa.utils.ApiUtils;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.ksuryawa.utils.RandomUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateEmployeeTests {

	@Test
	public void createEmployee() {

		Employee employee = Employee.builder()
				.setId(getId())
				.setFirstName(getFirstName())
				.setLastName(getLastName())
				.setEmail(getEmail())
				.build();

		Response response = RequestBuilder
				.buildRequestForPostCalls()
				.body(employee)
				.post("/employees");

		response.prettyPrint();
		System.out.println(response.statusCode());

		assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
		assertThat(response.time()).isLessThan(1000);

		ApiUtils.storeStringAsJson(FrameworkConstants.getResponseJsonFilePath(), response);
	}

	@Test
	public void createEmployeeUsingExternalFile() {

		String resource = ApiUtils.readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath() + "request.json")
				.replace("Id", String.valueOf(getId()))
				.replace("fname", getFirstName())
				.replace("lname", getLastName())
				.replace("emailId", getEmail());

		Response response = RequestBuilder.buildRequestForPostCalls()
				.body(resource)
				.post("/Employees");
		response.prettyPrint();
		System.out.println(response.statusCode());

		assertThat(response.statusCode()).isEqualTo(HttpStatus.SC_CREATED);
		assertThat(response.time()).isLessThan(1000);

		ApiUtils.storeStringAsJson(FrameworkConstants.getResponseJsonFilePath(), response);


	}
}