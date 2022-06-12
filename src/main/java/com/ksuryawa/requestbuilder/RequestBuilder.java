package com.ksuryawa.requestbuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static com.ksuryawa.config.factory.ConfigFactory.getConfig;
import static io.restassured.RestAssured.given;

public final class RequestBuilder {

	private RequestBuilder() {
	}

	public static RequestSpecification buildRequestForGetCalls() {
		return given()
				.baseUri(getConfig().baseUrl())
				.log()
				.all();
	}

	public static RequestSpecification buildRequestForPostCalls() {
		return buildRequestForGetCalls()
				.contentType(ContentType.JSON);
	}

}