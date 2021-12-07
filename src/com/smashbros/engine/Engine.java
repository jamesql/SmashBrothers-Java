package com.smashbros.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.smashbros.interfaces.IRunnable;
import com.smashbros.objects.controllers.Controller;
import com.smashbros.objects.controllers.KeyActionPair;
import com.smashbros.objects.controllers.KeyboardController;
import com.smashbros.objects.Character;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Engine extends Window implements IRunnable {

	public Engine(double x, double y, Stage s) {
		super(x, y, s);
		setup();
		new KeyboardController(new Character(400, 200, "pgriff"));
		new KeyboardController(new Character(650, 100, "default"), KeyActionPair.DEFAULT_ARROW);

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
	
	public static void addNode(Node n) {
		Engine.root.getChildren().add(n);
	}
	
	public static Pane getPane() {
		return Engine.root;
	}
	
	public static Image readImage(String fileName) {
		try {
			return new Image(new FileInputStream(String.format("src\\com\\smashbros\\assets\\%s", fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void run() {
		
	}


}
