package com.ksuryawa.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"system:properties",
		"system:env",
		"file:${user.dir}/src/test/resources/config.properties"
})
public interface IFrameworkConfig extends Config {

	String baseUrl();
}