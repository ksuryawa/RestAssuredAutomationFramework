package com.ksuryawa.config.factory;

import com.ksuryawa.config.IFrameworkConfig;
import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {

	private ConfigFactory() {
	}

	public static IFrameworkConfig getConfig() {
		return ConfigCache.getOrCreate(IFrameworkConfig.class);
	}
}