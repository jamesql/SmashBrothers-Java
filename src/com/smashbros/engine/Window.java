package com.smashbros.engine;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Window extends Application {
	private static double x;
	private static double y;
	private static Pane root;
	private static ArrayList<Scene> scenes;
	private static Scene currentScene;
	private static Stage stage;
	private static Canvas canvas;
	private static GraphicsContext graphics;
	private static Tick engineTick;
	
	public Window(double x, double y) {
		this.x = x;
		this.y = y;
		launch();
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
		this.root = new Pane();
		this.stage = primaryStage;
		this.canvas = new Canvas(x,y);
		this.graphics = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		
		// change multiple scenes
		setScene(makeScene());
		
		stage.setTitle("Super Scuffed Bros");
		stage.setScene(currentScene);
		stage.setResizable(false);
		stage.show();
		
	}
}
