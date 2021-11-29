package com.smashbros.objects;

public class KeyValue<T> {
	private String key;
	private T value;
	
	public KeyValue(String k, T val) {
		key = k;
		value = val;
	}
	
	public T getValue() {
		return value;
	}
	
	public String getKey() {
		return key;
	}
	
}
