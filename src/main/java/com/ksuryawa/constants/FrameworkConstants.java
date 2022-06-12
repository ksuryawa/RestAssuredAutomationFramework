package com.ksuryawa.constants;

import lombok.Getter;

public final class FrameworkConstants {

	private static final String CURRENT_WORKING_DIRECTORY = System.getProperty("user.dir");
	private static final @Getter String RequestJsonFolderPath = CURRENT_WORKING_DIRECTORY + "/src/test/resources/json/requestbody/";
	private static final @Getter String ResponseJsonFilePath = CURRENT_WORKING_DIRECTORY + "/output/response/response.json";
	private static final @Getter String SchemaValidationJsonFilePath = CURRENT_WORKING_DIRECTORY + "/src/test/resources/json/schema/schema.json";
	private static final @Getter String ExtentReportFolderPath = CURRENT_WORKING_DIRECTORY + "/output/extentReports/";

	private FrameworkConstants() {
	}

}