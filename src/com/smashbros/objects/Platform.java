package com.smashbros.objects;

import java.util.ArrayList;

import com.smashbros.engine.Engine;
import com.smashbros.enums.EndBlocks;

public class Platform {
	private ArrayList<PlatformBlock> blocks = new ArrayList<>();
	private int blockWidth = 60;
	private int blockHeight = 60;

	public Platform(int x, int y, int numBlocks) {
		addPlatformRow(x, y, numBlocks);
		checkEnds();
	}
	
	public void checkEnds() {
        
		for(int i = 0; i < blocks.size(); i++) {
			if(i == 0) {
				blocks.get(i).getOverlay().setBlockType(EndBlocks.LEFTEND);
			} else if (i == blocks.size()-1) {
				blocks.get(i).getOverlay().setBlockType(EndBlocks.RIGHTEND);
			} else {
				blocks.get(i).getOverlay().setBlockType(EndBlocks.MIDDLE);
			}
		}
	}

	public void addPlatformRow(int x, int y, int blocks) {
		for (int i = 0; i < blocks; i++)
			addBlock((x + i * blockWidth), y);
	}

	public void addBlock(int x, int y) {
		PlatformBlock f = new PlatformBlock(x, y, blockWidth, blockHeight);
		Engine.addNode(f.getGraphic());
		blocks.add(f);
	}
}
