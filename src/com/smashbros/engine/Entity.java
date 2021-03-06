package com.smashbros.engine;

public class Entity {
	protected int x,y;
	private static int entityCount = 0;
	protected int eIndex;
	protected String type;
	
	public Entity(String t) {
		EntityList.addEntity(this);
		this.eIndex = ++entityCount;
		this.type = t;
	}
	
	public static void resetCount() {
		entityCount = 0;
	}
	
	public boolean isColliding() {
		return EntityList.isColliding(this);
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
