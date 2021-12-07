package com.smashbros.engine;

import com.smashbros.objects.ConfigData;

public class Config {
	private static Config _instance;
	
	private ConfigData data;
	
	public Config() {
		this.data = new ConfigData();
	}
	
	// set config data
	public Config(ConfigData data) {
		this.data = data;
	}
	
	public ConfigData getData() {
		return this.data;
	}
	
	public <T> void add(String key, T value) {
		this.data.add(key, value);
	}
	
	public <T> T get(String key) {
		return this.data.get(key);
	}
	
	public static Config instance() {
		if (_instance == null)
			_instance = new Config();
		
		return _instance;
	}
	
	
}
