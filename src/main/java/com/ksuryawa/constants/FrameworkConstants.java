package com.ksuryawa.constants;

public final class FrameworkConstants {

	private static final String CURRENT_WORKING_DIRECTORY = System.getProperty("user.dir");
	private static final String REQUEST_JSON_FOLDER_PATH = CURRENT_WORKING_DIRECTORY + "/src/test/resources/json/requestbody/";
	private static final String RESPONSE_JSON_FILE_PATH = CURRENT_WORKING_DIRECTORY + "/output/response/response.json";
	private static final String SCHEMA_VALIDATION_JSON_FILE_PATH = CURRENT_WORKING_DIRECTORY + "/src/test/resources/json/schema/schema.json";
	private static final String EXTENT_REPORT_FILE_PATH = CURRENT_WORKING_DIRECTORY + "/output/extentReports/index.html";

	private FrameworkConstants() {
	}

	public static String getRequestJsonFolderPath() {
		return REQUEST_JSON_FOLDER_PATH;
	}

	public static String getResponseJsonFilePath() {
		return RESPONSE_JSON_FILE_PATH;
	}

	public static String getSchemaValidationJsonFilePath() {
		return SCHEMA_VALIDATION_JSON_FILE_PATH;
	}

	public static String getExtentReportFilePath() {
		return EXTENT_REPORT_FILE_PATH;
	}
}