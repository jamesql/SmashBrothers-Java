package com.smashbros.engine;

import com.smashbros.objects.ConfigData;

public class Config {
	private static Config _instance;
	
	private ConfigData data;
	
	// set config data
	private Config() {
		this.data = new ConfigData();
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
	
	public <T> void set(String key, T value) {
		this.data.set(key, value);
	}
	
	public static Config instance() {
		if (_instance == null)
			_instance = new Config();
		
		return _instance;
	}
	
	
}
