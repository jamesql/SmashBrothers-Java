package com.smashbros.engine;

import java.util.ArrayList;

import com.smashbros.interfaces.IRunnable;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Tick {
	private static ArrayList<IRunnable> list = new ArrayList<IRunnable>();
	private static EventHandler<ActionEvent> e;
	private static Timeline t;
	
	public static void addToLoop(IRunnable t) {
		list.add(t);
	}
	
	public static void runAll() {
		list.forEach(i -> i.run());
	}
	
	public static EventHandler<ActionEvent> getEventHandler() {
		return Tick.e;
	}
	
	static {
		 Tick.e = new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				Tick.runAll();
			}
			 
		 };
		 
		 Tick.t = new Timeline(new KeyFrame(Duration.millis(17), Tick.e));
		 Tick.t.setCycleCount(Timeline.INDEFINITE);
		 Tick.t.play();
	}
	
}
