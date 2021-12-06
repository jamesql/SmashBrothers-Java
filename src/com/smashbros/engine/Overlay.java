package com.smashbros.engine;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class Overlay {
	protected int x,y;
	protected int oIndex;
	protected String type;
	private static int overlayCount = 0;
	
    protected ArrayList<Node> overlayNodeList = new ArrayList<>();
    protected ArrayList<ImageView> spriteList = new ArrayList<>();
    
    public Overlay(String t) {
    	this.type = t;
    	this.oIndex = ++overlayCount;
    	OverlayList.addOverlay(this);
    }
    
    protected void addNodesToEngine() {
    	for (Node n : overlayNodeList) {
    		n.toFront();
    		Engine.addNode(n);
    	}
    	for (ImageView i : spriteList) {
    		i.toFront();
    		Engine.addNode(i);
    	}
    }
    
	public abstract void render();
}
