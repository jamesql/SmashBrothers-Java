package com.smashbros.objects;

import com.smashbros.engine.Entity;
import com.smashbros.interfaces.IHitbox;

public class PlatformBlock extends Entity implements IHitbox {
	
	
	public PlatformBlock(String t) {
		super("platform");
	}

	@Override
	public Hitbox getHitbox() {
		// TODO Auto-generated method stub
		return null;
	}

}
