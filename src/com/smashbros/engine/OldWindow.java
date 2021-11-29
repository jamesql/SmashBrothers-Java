package com.smashbros.engine;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OldWindow extends Application {
	protected static double x;
	protected static double y;
	protected static Pane root;
	protected static ArrayList<Scene> scenes = new ArrayList<Scene>();
	protected static Scene currentScene;
	protected static Stage stage;
	protected static Canvas canvas;
	protected static GraphicsContext graphics;
	
	public OldWindow(double x, double y, String[] args) {
		OldWindow.x = x;
		OldWindow.y = y;
		launch(args);
	}
	
	public OldWindow() {
		
	}
	
	public static void setScene(Scene s) {
		currentScene = s;
	}
	
	public static Scene makeScene() {
		Scene thisScene = new Scene(root, x, y);
		scenes.add(thisScene);
		return thisScene;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		OldWindow.root = new Pane();
		OldWindow.stage = primaryStage;
		OldWindow.canvas = new Canvas(x,y);
		OldWindow.graphics = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		
		// change multiple scenes
		setScene(makeScene());
		
		stage.setTitle("Super Scuffed Bros");
		stage.setScene(currentScene);
		stage.setResizable(false);
		stage.show();
		
	}
}
