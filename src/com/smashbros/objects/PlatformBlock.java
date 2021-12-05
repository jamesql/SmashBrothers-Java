package com.smashbros.objects;

import com.smashbros.engine.Entity;
import com.smashbros.interfaces.IHitbox;

import javafx.scene.shape.Rectangle;

public class PlatformBlock extends Entity implements IHitbox {
	private Rectangle graphic;
	private Hitbox hbox;
	private int x;
	private int y;
	
	public PlatformBlock(int x, int y, int w, int h) {
		super("platform");
		this.x = x;
		this.y = y;
		this.graphic = new Rectangle(x, y, w, h);
		this.hbox = new Hitbox(graphic);
		
	}

	@Override
	public Hitbox getHitbox() {
		return hbox;
	}
	
	public Rectangle getGraphic() {
		return this.graphic;
	}

}
