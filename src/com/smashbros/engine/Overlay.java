package com.smashbros.engine;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Overlay {
    protected int x,y;
	private static int overlayCount = 0;
	protected int oIndex;
	protected String type;
    protected ArrayList<Node> n = new ArrayList<>();
    protected ArrayList<ImageView> SpriteList = new ArrayList<>();

	public Overlay(String t) {
		OverlayList.addOverlay(this);
        addNodesToEngine();
		this.oIndex = ++overlayCount;
		this.type = t;
	}

    protected void addNodesToEngine() {
        for(Node node : n) {
            Engine.addGraphic(node);
        }

        for(ImageView i : SpriteList) {
            Engine.addImage(i);
        }
    }
}
