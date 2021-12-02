package com.smashbros.objects;

import com.smashbros.engine.Engine;
import com.smashbros.engine.Entity;
import com.smashbros.engine.EntityList;
import com.smashbros.interfaces.IControllable;
import com.smashbros.interfaces.IDrawable;
import com.smashbros.interfaces.IHitbox;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Character extends Entity implements IDrawable, IControllable, IHitbox {
	private Rectangle vbox;
	private Hitbox hbox;
	private Hitbox gbox;
	
	public Character() {
		super("character");
		this.vbox = new Rectangle(150, 150, 50, 50);
		vbox.setFill(Color.GOLD);
		Engine.addGraphic(vbox);
		this.hbox = new Hitbox(this.vbox);
		this.gbox = hbox;
	}
	
	public void updateGhostBox(int xChange, int yChange) {
		this.gbox = getModifiedHitbox(xChange, yChange);
	}
	
	public Hitbox getModifiedHitbox(int xChange, int yChange) {		
		return new Hitbox(gbox.getMinX()+xChange, gbox.getMinY()+yChange, gbox.getMaxX(), gbox.getMaxY());
	}
	
	@Override
	public void draw() {
		
		if (!EntityList.isCollidingGhostBox(eIndex, gbox)) {
			this.x = gbox.getMinX();
			this.y = gbox.getMinY();
		}
		
		vbox.setX(this.x);
		vbox.setY(this.y);
	}

	@Override
	public void jump() {
		updateGhostBox(0, -5);
	}

	@Override
	public void left() {
		updateGhostBox(-5, 0);
	}

	@Override
	public void right() {
		updateGhostBox(5, 0);		
	}

	@Override
	public void down() {
		updateGhostBox(0, 5);		
	}

	@Override
	public Hitbox getHitbox() {
		return this.hbox;
	}

}
