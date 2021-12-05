package com.smashbros.objects;

import com.smashbros.engine.Overlay;

public class CharacterOverlay extends Overlay {
	private Character c;
	
	public CharacterOverlay(Character c) {
		super("sprite");
		this.c = c;
		this.x = c.getX();
		this.y = c.getY();
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
