package com.ksuryawa.utils;

public final class RandomUtils {

	private RandomUtils() {
	}

	public static int getId() {
		return FakerUtils.getNumber(100, 10000);
	}

	public static String getFirstName() {
		return FakerUtils.getFirstName();
	}

	public static String getLastName() {
		return FakerUtils.getLastName();
	}

	public static String getEmail() {
		return FakerUtils.getEmail();
	}

}