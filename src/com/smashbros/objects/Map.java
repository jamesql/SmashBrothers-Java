package com.smashbros.objects;

import java.util.ArrayList;

import com.smashbros.engine.Config;
import com.smashbros.engine.Engine;
import com.smashbros.engine.Overlay;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Map extends Overlay {
	private ArrayList<Platform> rows = new ArrayList<Platform>();
	private String ln;
	private Image i;
	private ImageView bg;
	private Config cfg = Config.instance();
	
	public Map(String levelName) {
		super(levelName);
		cfg.set("currentMap", levelName);
		this.ln = levelName;
		this.i = !levelName.equals("vpw1") ? Engine.readImage(String.format("map-%s.png", levelName)) 
			: Engine.readImage(String.format("map-%s.gif",levelName));
		this.bg = new ImageView(i);
		bg.setFitHeight(cfg.get("windowY"));
		bg.setFitWidth(cfg.get("windowX"));
		spriteList.add(this.bg);
		this.addNodesToEngine();
		bg.toBack();
	}
	
	public void addPlatformRow(int x, int y, int blocks) {
		rows.add(new Platform(x, y, blocks));
	}

	@Override
	public void render() {
		// unused
	}
}
