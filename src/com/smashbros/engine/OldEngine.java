package com.smashbros.engine;

import com.smashbros.interfaces.IRunnable;
import com.smashbros.objects.Character;
import com.smashbros.objects.controllers.Controller;
import com.smashbros.objects.controllers.KeyboardController;

public class OldEngine extends OldWindow implements IRunnable {	
	
	public OldEngine(double x, double y, String[] args) {
		super(x, y, args);
		//Character ch = new Character();
		//KeyboardController c = new KeyboardController(ch);
		System.out.println("start");
	}
	
	public OldEngine() {
		
	}
	
	public void setup() {
		root.requestFocus();
		
		root.setOnKeyPressed((key) -> {
			Controller.keyPress(key.getCode());
		});
		
		root.setOnKeyReleased((key) -> {
			Controller.keyRelease(key.getCode());
		});
	}

	@Override
	public void run() {
		System.out.println("kjkjkj");

		
	}

}
