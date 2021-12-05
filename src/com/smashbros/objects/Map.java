package com.smashbros.objects;

import java.util.ArrayList;

import com.smashbros.engine.Engine;

public class Map {
	private ArrayList<PlatformBlock> blocks = new ArrayList<PlatformBlock>();

	private int blockWidth = 60;
	private int blockHeight = 60;
	
	public Map() {
		
	}
	
	public void addPlatformRow(int x, int y, int blocks) {
		for (int i = 0; i < blocks; i++)
			addBlock((x+i*blockWidth), y);
	}
	
	public void addBlock(int x, int y) {
		PlatformBlock f = new PlatformBlock(x, y, blockWidth, blockHeight);
		Engine.addNode(f.getGraphic());
		blocks.add(f);
	}
}
