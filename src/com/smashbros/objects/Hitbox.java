package com.smashbros.objects;

public class Hitbox {
	private int minX, minY, maxX, maxY;
	
	public Hitbox(int minX, int minY, int maxX, int maxY) {
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public boolean isColliding(Hitbox hb) {
		return maxX >= hb.minX && minX <= hb.maxX && maxY >= hb.minY 
				&& minY <= hb.maxY;
	}
}
