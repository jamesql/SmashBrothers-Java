package com.smashbros.objects;

import com.smashbros.engine.Entity;
import com.smashbros.interfaces.IHitbox;

import javafx.scene.shape.Rectangle;

public class PlatformBlock extends Entity implements IHitbox {
	private Rectangle graphic;
	private Hitbox hbox;
	private int h;
	private int w;
	private PlatformOverlay overlay;
	
	public PlatformBlock(int x, int y, int w, int h) {
		super("platform");
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.graphic = new Rectangle(x, y, w, h);
		this.hbox = new Hitbox(graphic);
		graphic.setVisible(false);
		this.overlay = new PlatformOverlay(this);
	}

	@Override
	public Hitbox getHitbox() {
		return hbox;
	}
	
	public Rectangle getGraphic() {
		return this.graphic;
	}
	
	public PlatformOverlay getOverlay() {
		return this.overlay;
	}
	
	public int getWidth() {
		return this.w;
	}
	
	public int getHeight() {
		return this.h;
	}

}