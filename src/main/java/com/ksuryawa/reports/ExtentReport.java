package com.ksuryawa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ksuryawa.constants.FrameworkConstants;

public final class ExtentReport {

	private static ExtentReports extentReports;

	private ExtentReport() {
	}

	public static void initReports() {
		extentReports = new ExtentReports();
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
		extentReports.attachReporter(extentSparkReporter);
	}

	public static void tearDownReports() {
		extentReports.flush();
	}

	public static void createTest(String name) {
		ExtentTest test = extentReports.createTest(name);
		ExtentManager.setExtent(test);
	}

	public static void addAuthor(String[] authors) {
		for (String author : authors) {
			ExtentManager.getTest().assignAuthor(author);
		}
	}

	public static void addCategory(String[] categories) {
		for (String category : categories) {
			ExtentManager.getTest().assignCategory(category);
		}
	}
}