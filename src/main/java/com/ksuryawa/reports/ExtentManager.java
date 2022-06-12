package com.ksuryawa.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

	private ExtentManager() {
	}

	static ExtentTest getTest() {
		return extentTestThreadLocal.get();
	}

	static void setExtent(ExtentTest test) {
		extentTestThreadLocal.set(test);
	}
}