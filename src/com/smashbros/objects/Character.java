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
	private int jumpCount = 0;
	private int health = 0;
	private int lives = 3;
	private Direction dir = Direction.RIGHT;
	private CharacterOverlay chOverlay;
	private HealthBar hb;
	private String characterName;
	private Point2D origin;
	private boolean blocking = false;
	
	public Character(int x, int y, String character) {
		super("character");
		this.vbox = new Rectangle(x, y, 50, 50);
		vbox.setFill(Color.TRANSPARENT);
		Engine.addNode(vbox);
		this.characterName = character;
		chOverlay = new CharacterOverlay(this, character);
		this.hbox = new Hitbox(this.vbox);
		this.gbox = new Hitbox(this.vbox);
		this.kList = new KeyFrameList();
		this.origin = new Point2D(x, y);
		
		hb = new HealthBar(this);

		kList.addKeyFrame(new KeyFrame(this, 100, KeyFrameType.GRAVITY, 0));
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
	
	public void resetBox() {
		vbox.setX(origin.getX());
		vbox.setY(origin.getY());
		this.gbox = new Hitbox(vbox);
	}
	
	public void resetJump() {
		jumpCount = 0;
	}
	
	public Direction getDir() {
		return this.dir;
	}
	
	public CharacterOverlay getOverlay() {
		return this.chOverlay;
	}
	
	public boolean isFrozen() {
		return kList.numOfType(KeyFrameType.KNOCKBACK) > 0;
	}
	
	public void knockback(Direction d) {
		dir = d;
		kList.addKeyFrame(new KeyFrame(this, 15, KeyFrameType.KNOCKBACK, 15));
	}
	
	public void resetKeyFrames() {
		kList.clearList();
		kList.addKeyFrame(new KeyFrame(this, 100, KeyFrameType.GRAVITY, 0));
	}
	
	@Override
	public void draw() {
		
		Point2D z = kList.getNextFrame(this.dir);
		updateGhostBox(z);
		
		int yChange = Math.abs(gbox.getMinY() - hbox.getMinY());
		
		if (!EntityList.isCollidingGhostBox(eIndex, gbox, yChange)) {
			this.x = gbox.getMinX();
			this.y = gbox.getMinY();
		} else 
			gbox = new Hitbox(vbox);
		
		vbox.setX(this.x);
		vbox.setY(this.y);
		
		// EntityList attack
		if (isAttacking()) EntityList.checkAttackingHits(this);
		
		this.hbox.updateFromGraphic();
		
		if (y > 850 || x < -100 || x > 1400) die();
		
	}

	@Override
	public void jump() {
		if (!(kList.isOnCooldown(KeyFrameType.JUMPING)) && jumpCount < 2) {
			kList.addKeyFrame(new KeyFrame(this, 60, KeyFrameType.JUMPING, 55));
			jumpCount++;
		}
	}

	@Override
	public void left() {
		if (isFrozen()) return;
		updateGhostBox(-5, 0);
		dir = Direction.LEFT;
	}

	@Override
	public void right() {
		if (isFrozen()) return;
		updateGhostBox(5, 0);	
		dir = Direction.RIGHT;
	}

	@Override
	public void down() {
		if (isFrozen()) return;
		updateGhostBox(0, 8);		
	}
	
	@Override
	public void attack() {
		if (isFrozen()) return;
		kList.addKeyFrame(new KeyFrame(this, 5, KeyFrameType.ATTACKING, 9));
	}
	
	@Override
	public void block() {
		if (isFrozen()) return;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hitbox getHitbox() {
		return this.hbox;
	}

	@Override
	public void setLives(int l) {
		this.lives = l > 0 ? l : 0;
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
		double hHealth = health > 125 ? 125 : health;
		double green = 1-((hHealth/255.0)*2);
		double red = hHealth/255;
		
		red = red > 1.0 ? 1.0 : red;
		green = green < 0.0 ? 0.0 : green;
		return new Color(red, green, 0, 1);
	}

	@Override
	public boolean isAttacking() {
		return kList.numOfType(KeyFrameType.ATTACKING) > 0 ? true : false;
	}

	@Override
	public void die() {
		setLives(this.lives-1);
		setHealth(0);
		resetKeyFrames();
		
		if (lives > 0) resetBox();
		else resetBox(); // dead for good
		
	}

	@Override
	public boolean isBlocking() {
		return this.blocking;
	}

}
