package com.smashbros.objects;

import java.util.ArrayList;

import com.smashbros.engine.Overlay;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class HealthBar extends Overlay {
	private Character c;
	private Text perc = new Text();
	private ArrayList<ImageView> lives = new ArrayList<ImageView>();
	
	public HealthBar(Character c) {
		super("Hb");
		this.c = c;
	}
	
	public void setPos(int x, int y) {
		
	}
	
	// TODO : OverlayList.getNumHealthbars(); : int
	public void setHealthBarPos() {
		
	}

	@Override
	public void render() {
		
	}

}
