package com.smashbros.objects;

import com.smashbros.engine.Engine;
import com.smashbros.engine.Entity;
import com.smashbros.engine.EntityList;
import com.smashbros.enums.Direction;
import com.smashbros.enums.KeyFrameType;
import com.smashbros.interfaces.IControllable;
import com.smashbros.interfaces.IDrawable;
import com.smashbros.interfaces.IHitbox;
import com.smashbros.interfaces.IHittable;
import com.smashbros.keyframes.KeyFrame;
import com.smashbros.keyframes.KeyFrameList;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Character extends Entity implements IDrawable, IControllable, IHitbox, IHittable {
	private Rectangle vbox;
	private Hitbox hbox;
	private Hitbox gbox;
	private KeyFrameList kList;
	private int health = 0; 
	private int lives = 3;
	private HealthBar h;
	private CharacterOverlay co; 
	private Direction dir;
	private int jumpCount = 0;
	
	public Character(int x, int y) {
		super("character");
		this.vbox = new Rectangle(x, y, 50, 50);
		vbox.setFill(Color.GOLD);
		Engine.addGraphic(vbox);
		this.hbox = new Hitbox(this.vbox);
		this.gbox = new Hitbox(this.vbox);
		this.kList = new KeyFrameList();
		
		kList.addKeyFrame(new KeyFrame(100, KeyFrameType.GRAVITY, 0));
		
		this.co = new CharacterOverlay(this);
		this.h = new HealthBar(this);
	}
	
	public void updateGhostBox(int xChange, int yChange) {
		this.gbox = getModifiedHitbox(xChange, yChange);
	}
	
	public void updateGhostBox(Point2D change) {
		this.gbox = getModifiedHitbox((int)change.getX(), (int)change.getY());
	}
	
	public Hitbox getModifiedHitbox(int xChange, int yChange) {		
		Bounds vboxBounds = vbox.getBoundsInParent();
		return new Hitbox(gbox.getMinX()+xChange, gbox.getMinY()+yChange, vboxBounds.getMaxX()+xChange, vboxBounds.getMaxY()+yChange);
	}
	
	public void resetJump() {
		jumpCount = 0;
	}
	
	@Override
	public void draw() {
		
		Point2D z = kList.getNextFrame();
		updateGhostBox(z);
		
		int yChange = Math.abs(gbox.getMinY() - hbox.getMinY());
		
		if (!EntityList.isCollidingGhostBox(eIndex, gbox, yChange)) {
			this.x = gbox.getMinX();
			this.y = gbox.getMinY();
		} else 
			gbox = new Hitbox(vbox);
		
		vbox.setX(this.x);
		vbox.setY(this.y);
		this.hbox.updateFromGraphic();
	}

	@Override
	public void jump() {
		if (!(kList.isOnCooldown(KeyFrameType.JUMPING)) && jumpCount < 2) {
			kList.addKeyFrame(new KeyFrame(60, KeyFrameType.JUMPING, 55));
			jumpCount++;
		}
	}

	@Override
	public void left() {
		updateGhostBox(-5, 0);
		dir = Direction.LEFT;

	}

	@Override
	public void right() {
		updateGhostBox(5, 0);	
		dir = Direction.RIGHT;	
	}

	@Override
	public void down() {
		updateGhostBox(0, 5);		
	}

	@Override
	public Hitbox getHitbox() {
		return this.hbox;
	}

	@Override
	public void setLives(int l) {
		this.lives = lives > 0 ? l : 0;
	}

	@Override
	public int getLives() {
		return this.lives;
	}

	@Override
	public void setHealth(int h) {
		this.health = h;
	}

	@Override
	public int getHealth() {
		return this.health;
	}

	@Override
	public Color colorHealthIndicator() {
		return health < 100 ? Color.GREEN : Color.RED;
	}

	public HealthBar getHealthBar() {
		return h;
	}

	public CharacterOverlay getCharOverlay() {
		return co;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Direction getDir() {
		return dir;
	}

}
