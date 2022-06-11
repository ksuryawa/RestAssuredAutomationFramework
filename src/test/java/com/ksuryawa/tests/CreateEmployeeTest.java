package com.ksuryawa.tests;

import com.ksuryawa.pojo.Employee;
import com.ksuryawa.requestbuilder.RequestBuilder;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static com.ksuryawa.utils.RandomUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateEmployeeTest {

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

	}
}