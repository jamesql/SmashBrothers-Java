package com.smashbros.objects;

public class Map {
	
	public Map() {
		setBackground("default");
	}

	public void setBackground(String s) {
		new MapBackground(s);
	}

	public void addPlatform(int x, int y, int blocks) {
		new Platform(x, y, blocks);
	}
	
}
