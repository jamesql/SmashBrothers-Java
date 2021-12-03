package com.smashbros.keyframes;

import java.util.ArrayList;

import com.smashbros.enums.KeyFrameType;

import javafx.geometry.Point2D;

public class KeyFrameList {
	private ArrayList<KeyFrame> list = new ArrayList<KeyFrame>();

	public KeyFrameList() {
		
	}
	
	public Point2D getNextFrame() {
		collectGarbage();
		double x=0, y=0;
		
		for (KeyFrame k : list) {
			Point2D t = k.getNextFrame();
			x += t.getX();
			y += t.getY();
		}
		
		Point2D p = new Point2D(x, y);
		return p;
	}
	
	public void addKeyFrame(KeyFrame k) {
		list.add(k);
	}
	
	public boolean isOnCooldown(KeyFrameType type) {
		for (KeyFrame k : list) 
			if(k.getType().equals(type) && k.isOnCooldown()) return true;
		return false;
	}
	
	public void collectGarbage() {
		list.removeIf(x -> !x.hasFrames());
	}
	
	public int numOfType(KeyFrameType type) {
		int c = 0;
		for (KeyFrame k : list)
			if(k.getType().equals(type)) c++;
		return c;
	}
	
}
