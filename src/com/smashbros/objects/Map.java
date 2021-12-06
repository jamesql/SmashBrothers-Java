package com.smashbros.objects;

import java.util.ArrayList;

import com.smashbros.engine.Engine;

public class Map {
	private ArrayList<Platform> rows = new ArrayList<Platform>();
	
	public Map() {

	}
	
	public void addPlatformRow(int x, int y, int blocks) {
		rows.add(new Platform(x, y, blocks));
	}
}
