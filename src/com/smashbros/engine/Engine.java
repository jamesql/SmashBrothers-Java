package com.smashbros.engine;

import com.smashbros.interfaces.IRunnable;
import com.smashbros.objects.controllers.Controller;
import com.smashbros.objects.controllers.KeyboardController;
import com.smashbros.objects.Character;

import javafx.stage.Stage;

public class Engine extends Window implements IRunnable {

	public Engine(double x, double y, Stage s) {
		super(x, y, s);
		setup();
		new KeyboardController(new Character());
	}
	
	public void setup() {
		root.requestFocus();
		
		root.setOnKeyPressed((key) -> {
			Controller.keyPress(key.getCode());
		});
		
		root.setOnKeyReleased((key) -> {
			Controller.keyRelease(key.getCode());
		});
		
		Tick.addToLoop(this);
	}

	@Override
	public void run() {
		
	}


}
