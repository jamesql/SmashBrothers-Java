package com.smashbros.objects;

import javafx.geometry.Bounds;

public class Hitbox {
	private int minX, minY, maxX, maxY;
	
	public Hitbox(int minX, int minY, int maxX, int maxY) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public Hitbox(Bounds b) {
		this.minX = (int) b.getMinX();
		this.minY = (int) b.getMinY();
		this.maxX = (int) b.getMaxX();
		this.maxY = (int) b.getMaxY();
	}
	
	public boolean isColliding(Hitbox hb) {
		return maxX >= hb.minX && minX <= hb.maxX && maxY >= hb.minY 
				&& minY <= hb.maxY;
	}
}
