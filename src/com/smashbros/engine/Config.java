package com.smashbros.engine;

import com.smashbros.objects.ConfigData;

public class Config {
	private static Config _instance;
	
	private ConfigData data;
	
	public Config() {
		
	}
	
	// set config data
	public Config(ConfigData data) {
		this.data = data;
	}
	
	public Config instance() {
		if (_instance == null)
			_instance = new Config();
		
		return _instance;
	}
	
	
}
