package com.ksuryawa.listeners;

import com.ksuryawa.annotations.FrameworkAnnotations;
import com.ksuryawa.reports.ExtentLogger;
import com.ksuryawa.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.tearDownReports();
	}

	@Override
	public void onTestStart(ITestResult result) {

		ExtentReport.createTest(result.getName());
		FrameworkAnnotations annotations = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class);

		ExtentReport.addAuthor(annotations.author());
		ExtentReport.addCategory(annotations.category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(String.valueOf(result.getThrowable()));
	}
}