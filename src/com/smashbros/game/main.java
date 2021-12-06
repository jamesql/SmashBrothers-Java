package com.smashbros.game;

import com.smashbros.engine.Config;
import com.smashbros.engine.Engine;
import com.smashbros.engine.Tick;
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
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Engine(cfg.get("windowX"), cfg.get("windowY"), primaryStage);
		
		Map m = new Map("default");
		m.addPlatformRow(280, 655, 12);
		m.addPlatformRow(285, 450, 3);
	}

}
