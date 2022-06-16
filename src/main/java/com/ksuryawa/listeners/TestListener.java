package com.ksuryawa.listeners;

import com.ksuryawa.annotations.FrameworkAnnotations;
import com.ksuryawa.constants.FrameworkConstants;
import com.ksuryawa.reports.ExtentLogger;
import com.ksuryawa.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.tearDownReports();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		String description = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class).description();

		if (description.isEmpty() || description.isBlank()) {
			ExtentReport.createTest(result.getName());

		} else {
			ExtentReport.createTest(description);
		}

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