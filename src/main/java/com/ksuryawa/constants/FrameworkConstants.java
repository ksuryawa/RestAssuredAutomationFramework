package com.ksuryawa.constants;

import lombok.Getter;

public final class FrameworkConstants {


	private static final @Getter String RequestJsonFolderPath = System.getProperty("user.dir") + "/src/test/resources/jsons/";
	private static final @Getter String ResponseJsonFilePath = System.getProperty("user.dir") + "/output/response/response.json";

	private FrameworkConstants() {
	}

}