package com.smashbros.objects;

import com.smashbros.engine.Engine;
import com.smashbros.engine.Entity;
import com.smashbros.interfaces.IControllable;
import com.smashbros.interfaces.IDrawable;
import com.smashbros.interfaces.IHitbox;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Character extends Entity implements IDrawable, IControllable, IHitbox {
	private Rectangle vbox;
	private Hitbox hbox;
	
	public Character() {
		super("character");
		this.vbox = new Rectangle(150, 150, 50, 50);
		vbox.setFill(Color.GOLD);
		Engine.addGraphic(vbox);
		this.hbox = new Hitbox(this.vbox.getBoundsInParent());
	}
	
	@Override
	public void draw() {
		vbox.setX(this.x);
		vbox.setY(this.y);
	}

	@Override
	public void jump() {
		this.y -= 5;
		
	}

	@Override
	public void left() {
		this.x -= 5;
	}

	@Override
	public void right() {
		this.x += 5;
		
	}

	@Override
	public void down() {
		this.y += 5;
		
	}

	@Override
	public Hitbox getHitbox() {
		return this.hbox;
	}

}
