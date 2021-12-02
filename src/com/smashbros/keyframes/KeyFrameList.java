package com.smashbros.keyframes;

import java.util.ArrayList;

import javafx.geometry.Point2D;

public class KeyFrameList {
	private ArrayList<KeyFrame> list = new ArrayList<KeyFrame>();

	public KeyFrameList() {
		
	}
	
	public Point2D getNextFrame() {
		Point2D x = new Point2D(2, 2);
		return x;
	}
	
}
