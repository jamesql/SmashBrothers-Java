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
	
	public void setValue(T value2) {
		this.value = value2;
	}
	
	public String getKey() {
		return key;
	}
}
