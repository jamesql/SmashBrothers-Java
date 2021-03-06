package com.smashbros.keyframes;

import com.smashbros.enums.KeyFrameType;
import com.smashbros.objects.Character;

import javafx.geometry.Point2D;

public class KeyFrame {
	private int curFrame = 0;
	private int maxFrames;
	private int frameCooldown;
	private KeyFrameType type;
	private Character c;
	
	public KeyFrame(Character c, int frames, KeyFrameType type, int cooldown) {
		this.maxFrames = frames;
		this.type = type;
		this.frameCooldown = cooldown;
		this.c = c;
	}
	
	public Point2D getNextJumpFrame() {		
		
		if (curFrame == 0) {
			curFrame = maxFrames/2;
			frameCooldown *= 1.75;
		}
		
		int y = (int) ((-1/maxFrames)*Math.pow(curFrame, 2)+curFrame);
		
		y/=8;
		
		curFrame++;
		return new Point2D(0, -y);
	}
	
	public Point2D getNextGravityFrame() {
		return new Point2D(0,3);
	}
	
	private Point2D getNextAttackingFrame() {
		curFrame++;
		return new Point2D(0,0);
	}
	
	private Point2D getNextKnockbackFrame() {
		int x = maxFrames - curFrame;
		int y = (int) ((0.5 + (c.getHealth()/100))*-x);
		
		curFrame++;
		return new Point2D(x,y);
	}
	
	public Point2D getNextFrame() {
		if (!hasFrames()) return null;
		
		switch(type) {
		case JUMPING:
			return getNextJumpFrame();
		case GRAVITY:
			return getNextGravityFrame();
		case ATTACKING:
			return getNextAttackingFrame();
		case KNOCKBACK:
			return getNextKnockbackFrame();
		default:
			return null;
		}
	}

	public boolean isOnCooldown() {
		return !(curFrame > frameCooldown);
	}
	
	public boolean hasFrames() {
		return !(curFrame >= maxFrames);
	}
	
	public KeyFrameType getType() {
		return this.type;
	}
	
}
