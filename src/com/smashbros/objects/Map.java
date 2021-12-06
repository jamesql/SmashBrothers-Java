package com.smashbros.objects;

import java.util.ArrayList;

public class Map {
	private ArrayList<PlatformBlock> blocks = new ArrayList<PlatformBlock>();

	private int blockWidth = 60;
	private int blockHeight = 60;
	
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
