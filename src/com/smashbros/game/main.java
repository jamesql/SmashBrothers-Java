package com.smashbros.game;

import com.smashbros.engine.Config;
import com.smashbros.engine.Engine;
import com.smashbros.engine.Tick;
import com.smashbros.gui.menu.CharacterSelect;
import com.smashbros.gui.menu.MainMenu;
import com.smashbros.gui.menu.MapSelect;
import com.smashbros.objects.Map;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	private static Config cfg = Config.instance();
	public static void main(String[] args) {
		new Tick();
		setupConfig();
		launch(args);
	}
	
	// config
	public static void setupConfig() {
		cfg.add("windowX", 1280.); // doubles
		cfg.add("windowY", 720.);
		
		
		// character file names
		cfg.add("currentMap", "none");
		cfg.add("char1", "default");
		cfg.add("char2", "pgriff");
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Engine(cfg.get("windowX"), cfg.get("windowY"), primaryStage);
		
		new MainMenu();
		new MapSelect();
		new CharacterSelect();
		
		Engine.nextScene();
		
	}
}
