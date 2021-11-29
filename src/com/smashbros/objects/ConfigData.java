package com.smashbros.objects;

import java.util.ArrayList;

public class ConfigData {
	
	private ArrayList<KeyValue<?>> list = new ArrayList<KeyValue<?>>();
	
	public ConfigData() {
		list.add(new KeyValue<String>("y","n"));
	}
	
	public void mutate(ConfigData nData) {
		
	}
	
	public ArrayList<KeyValue<?>> getList() {
		return list;
	}
}
