package com.ksuryawa.utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

	private static final Faker faker = new Faker();

	private FakerUtils() {
	}

	static int getNumber(int startValue, int endValue) {
		return faker.number().numberBetween(startValue, endValue);
	}

	static String getFirstName() {
		return faker.name().firstName();
	}

	static String getLastName() {
		return faker.name().lastName();
	}

	static String getEmail() {
		return faker.internet().emailAddress();
	}

}