package com.smashbros.engine;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Window {
	protected static double x;
	protected static double y;
	protected static Pane root;
	protected static ArrayList<Scene> scenes = new ArrayList<Scene>();
	protected static Scene currentScene;
	protected static Stage stage;
	protected static Canvas canvas;
	protected static GraphicsContext graphics;
	
	public static void setScene(Scene s) {
		currentScene = s;
		stage.setScene(currentScene);
	}
	
	public static Scene makeScene() {
		Scene thisScene = new Scene(root, x, y);
		scenes.add(thisScene);
		return thisScene;
	}
	
	public static Scene makeScene(Pane p) {
		Scene thisScene = new Scene(p, x, y);
		scenes.add(thisScene);
		return thisScene;
	}
	
	public static void setStart() {
		stage.setScene(scenes.get(0));
	}
	
	public static void nextScene() {
		int index = scenes.indexOf(currentScene);
		Scene next = index == scenes.size()-1 ? scenes.get(0) : scenes.get(scenes.indexOf(currentScene)+1);
		System.out.println(next);
		setScene(next);
	}
 
	public Window(double x, double y, Stage s) {
		Window.x = x;
		Window.y = y;
		Window.stage = s;
		Window.root = new Pane();
		Window.stage = s;
		Window.canvas = new Canvas(x, y);
		Window.graphics = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		
		// change multiple scenes main menu etc
		setScene(makeScene());
		
		stage.setTitle("Super Scuffed Bros");
		stage.setScene(currentScene);
		stage.setResizable(false);
		stage.show();
	}
	
	
}
