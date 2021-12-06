package com.smashbros.objects;

import com.smashbros.engine.Engine;
import com.smashbros.engine.Overlay;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class CharacterOverlay extends Overlay {
	private Character c;
	private Image chrImg;
	private Image icon;
	private ImageView sprite;
	
	public CharacterOverlay(Character c) {
		super("sprite");
		this.c = c;
		this.x = c.getX();
		this.y = c.getY();
		
		this.chrImg = Engine.readImage("placeholderChar.png");
		this.icon = Engine.readImage("placeholderCharHB.png");
		this.sprite = new ImageView(chrImg);
		
		spriteList.add(sprite);
		sprite.setRotationAxis(Rotate.Y_AXIS);
		sprite.setFitHeight(50);
		sprite.setFitWidth(50);
		
		this.addNodesToEngine();
	}
	
	public void setDir() {
		switch (c.getDir()) {
		case LEFT:
			sprite.setRotate(180);
			break;
		case RIGHT:
			sprite.setRotate(0);
			break;
		}
	}

	@Override
	public void render() {
		sprite.setX(c.getX());
		sprite.setY(c.getY());
		setDir();
	}

}
