package com.smashbros.objects;

import java.util.ArrayList;

public class ConfigData {
	
	private ArrayList<KeyValue<?>> list = new ArrayList<KeyValue<?>>();
	
	public ConfigData() {
	}
	
	public void mutate(ConfigData nData) {
		
	}
	
	public <T> void add(String key, T value) {
		list.add(new KeyValue<T>(key, value));
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		for (KeyValue<?> kv : list)
			if (kv.getKey().equals(key)) return (T) kv.getValue();
				
		return null;
	}
	
	public <T> void set(String key, T value) {
		ArrayList<KeyValue<?>> delList = new ArrayList<KeyValue<?>>();
		
		for (KeyValue<?> kv : list)
			if (kv.getKey().equals(key)) delList.add(kv);
		
		list.removeAll(delList);
		
		add(key, value);
	}
	
	public ArrayList<KeyValue<?>> getList() {
		return list;
	}
}
