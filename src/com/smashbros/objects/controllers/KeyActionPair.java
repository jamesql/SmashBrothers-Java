package com.smashbros.objects.controllers;

import java.util.ArrayList;
import javafx.scene.input.KeyCode;

public class KeyActionPair {
	KeyCode keyCode;
	KeyAction action;
	
	public static final ArrayList<KeyActionPair> DEFAULT_WASD = new ArrayList<KeyActionPair>();
	public static final ArrayList<KeyActionPair> DEFAULT_ARROW = new ArrayList<KeyActionPair>();
	
	public KeyActionPair(KeyCode keyCode, KeyAction action) {
		this.keyCode = keyCode;
		this.action = action;
	}
	
	static {
		KeyActionPair[] wasd = new KeyActionPair[]{
				new KeyActionPair(KeyCode.SPACE, KeyAction.JUMP),
				new KeyActionPair(KeyCode.W, KeyAction.JUMP),
				new KeyActionPair(KeyCode.A, KeyAction.LEFT),
				new KeyActionPair(KeyCode.S, KeyAction.DOWN),
				new KeyActionPair(KeyCode.D, KeyAction.RIGHT),
				new KeyActionPair(KeyCode.R, KeyAction.ATTACK_GENERIC),
				new KeyActionPair(KeyCode.E, KeyAction.BLOCK)
		};
		KeyActionPair[] arrow = new KeyActionPair[]{
				new KeyActionPair(KeyCode.UP, KeyAction.JUMP),
				new KeyActionPair(KeyCode.LEFT, KeyAction.LEFT),
				new KeyActionPair(KeyCode.DOWN, KeyAction.DOWN),
				new KeyActionPair(KeyCode.RIGHT, KeyAction.RIGHT),
				new KeyActionPair(KeyCode.NUMPAD0, KeyAction.ATTACK_GENERIC),
				new KeyActionPair(KeyCode.SHIFT, KeyAction.BLOCK)
				
		};
		
		for (KeyActionPair p : wasd) DEFAULT_WASD.add(p);
		for (KeyActionPair p : arrow) DEFAULT_ARROW.add(p);
	}
	
	
}