package com.smashbros.engine;

import com.smashbros.interfaces.IRunnable;
import com.smashbros.objects.controllers.Controller;
import com.smashbros.objects.controllers.KeyActionPair;
import com.smashbros.objects.controllers.KeyboardController;
import com.smashbros.objects.Character;
import com.smashbros.objects.MapBackground;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Engine extends Window implements IRunnable {

	public Engine(double x, double y, Stage s) {
		super(x, y, s);
		setup();
		new KeyboardController(new Character());
		new KeyboardController(new Character(), KeyActionPair.DEFAULT_ARROW);
		new MapBackground("test");

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
	
	public static void addGraphic(Node s) {
		Engine.root.getChildren().add(s);
	}

	public static void addImage(ImageView i) {
		Engine.root.getChildren().add(i);
	}

	public static Pane getPane() {
		return Engine.root;
	}

	@Override
	public void run() {
		
	}


}
