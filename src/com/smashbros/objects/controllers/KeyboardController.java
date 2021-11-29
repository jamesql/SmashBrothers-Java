package com.smashbros.objects.controllers;

import java.util.ArrayList;

import com.smashbros.engine.Entity;
import com.smashbros.engine.Tick;
import com.smashbros.interfaces.IControllable;

import javafx.scene.input.KeyCode;

public class KeyboardController extends Controller {
	
	public KeyboardController(Entity e) {
		this.binds = KeyActionPair.DEFAULT_WASD;
		entity = e;
		addController(this);
		Tick.addToLoop(this);
	}
	
	public KeyboardController(Entity e, ArrayList<KeyActionPair> binds) {
		this.binds = binds;
		entity = e;
		addController(this);
		Tick.addToLoop(this);
	}
	
	@Override
	public void run() {
		if (!(entity instanceof IControllable)) return;
		
		IControllable cEntity = (IControllable) entity;

		for(KeyCode c : activeCodes) {
			KeyAction a = getAction(c, this.binds);
		
			if (a == null) continue;
				System.out.println(c);
			switch(a) {
			case JUMP:
				break;
			case DOWN:
				break;
			case LEFT:
				break;
			case RIGHT:
				break;
			default: break;
			}
		}
		
	}

}