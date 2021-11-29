package com.smashbros.game;

import com.smashbros.engine.Engine;
import com.smashbros.engine.Tick;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		new Tick();
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Engine(480, 480, primaryStage);
	}

}
