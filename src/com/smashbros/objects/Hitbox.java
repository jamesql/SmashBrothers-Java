package com.smashbros.objects;

import javafx.geometry.Bounds;
import javafx.scene.shape.Shape;

public class Hitbox {
	private int minX, minY, maxX, maxY;
	private Shape vbox;
	
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
	
	public Hitbox(double minX, double minY, double maxX, double maxY) {
		this.minX = (int) minX;
		this.minY = (int) minY;
		this.maxX = (int) maxX;
		this.maxY = (int) maxY;
	}
	
	
	public Hitbox(Shape g) {
		this.vbox = g;
		this.updateFromGraphic();
	}
	
	public void updateFromGraphic() {
		if (vbox == null) return;
		
		Bounds b = vbox.getBoundsInParent();
		
		this.minX = (int) b.getMinX();
		this.minY = (int) b.getMinY();
		this.maxX = (int) b.getMaxX();
		this.maxY = (int) b.getMaxY();
	}
	
	public int getMinX() {
		return this.minX;
	}
	
	public int getMinY() {
		return this.minY;
	}
	
	public int getMaxX() {
		return this.maxX;
	}
	
	public int getMaxY() {
		return this.maxY;
	}
	
	public boolean isColliding(Hitbox hb) {
		updateFromGraphic();
		return maxX >= hb.minX && minX <= hb.maxX && maxY >= hb.minY 
				&& minY <= hb.maxY;
	}
	
	public void changeY(int change) {
		this.minY += change;
		this.maxY += change;
	}
	
	@Override
	public String toString() {
		return String.format("minX: %d, minY: %d, maxX: %d, maxY: %d", minX, minY, maxX, maxY);
	}
}
