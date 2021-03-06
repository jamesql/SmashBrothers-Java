package com.smashbros.engine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.smashbros.gui.menu.CharacterSelect;
import com.smashbros.gui.menu.MainMenu;
import com.smashbros.gui.menu.MapSelect;
import com.smashbros.interfaces.IRunnable;
import com.smashbros.objects.controllers.Controller;
import com.smashbros.objects.controllers.KeyActionPair;
import com.smashbros.objects.controllers.KeyboardController;
import com.smashbros.objects.Character;
import com.smashbros.objects.HealthBar;
import com.smashbros.objects.Map;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Engine extends Window implements IRunnable {
	static Config cfg = Config.instance();
	
	public Engine(double x, double y, Stage s) {
		super(x, y, s);
		setup();
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
	
	public static void setMap() {
		Engine.root.getChildren().clear();
		Controller.killAll();
		HealthBar.resetHbCount();
		EntityList.clearList();
		
		new KeyboardController(new Character(400, 200, cfg.get("char1")));
		new KeyboardController(new Character(650, 100, cfg.get("char2")), KeyActionPair.DEFAULT_ARROW);

		Map m = new Map(cfg.get("currentMap"));
		m.addPlatformRow(280, 655, 12);
		m.addPlatformRow(285, 450, 3);
		
		setScene(root.getScene());
	}
	
	public static void resetGame() {
		Engine.root.getChildren().clear();
		setScene(scenes.get(1));
		
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
