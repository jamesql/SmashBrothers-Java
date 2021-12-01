package com.smashbros.objects.controllers;

import java.util.ArrayList;
import java.util.Collections;
import com.smashbros.engine.Entity;
import com.smashbros.interfaces.IRunnable;

import javafx.scene.input.KeyCode;

public abstract class Controller implements IRunnable {
	private static ArrayList<Controller> controllers = new ArrayList<Controller>();
	protected ArrayList<KeyActionPair> binds;
	protected Entity entity;
	
	protected static ArrayList<KeyCode> activeCodes = new ArrayList<KeyCode>();
	
	public static void addController(Controller c) {
		controllers.add(c);
	}
	
	public static KeyAction getAction(KeyCode c, ArrayList<KeyActionPair> list) {
		for (KeyActionPair p : list) {
			if (p.keyCode.equals(c)) return p.action;
		}
		
		return null;
	}
	
	public static void keyPress(KeyCode c) {
		for (KeyCode x : activeCodes) if (x.equals(c)) return;
		activeCodes.add(c);
	}
	
	public static void keyRelease(KeyCode c) {
		activeCodes.removeAll(Collections.singletonList(c));
	}
}
