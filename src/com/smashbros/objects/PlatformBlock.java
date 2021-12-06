package com.smashbros.objects;

import com.smashbros.engine.Entity;
import com.smashbros.interfaces.IHitbox;

import javafx.scene.shape.Rectangle;

public class PlatformBlock extends Entity implements IHitbox {
	private Rectangle graphic;
	private Hitbox hbox;
	private int x;
	private int y;
	private int w;
	private int h;
	private PlatformOverlay po;
	
	public PlatformBlock(int x, int y, int w, int h) {
		super("platform");
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.graphic = new Rectangle(x, y, w, h);
		graphic.setVisible(false);
		this.hbox = new Hitbox(graphic);
		this.po = new PlatformOverlay(this);
	}

	@Override
	public Hitbox getHitbox() {
		return hbox;
	}
	
	public Rectangle getGraphic() {
		return this.graphic;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getW() {
		return this.w; 
	}

	public int getH() {
		return this.h;
	}

	public PlatformOverlay getOverlay() {
		return this.po;
	}
	
}
