package com.smashbros.engine;

import java.util.ArrayList;

import com.smashbros.interfaces.IRunnable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Tick {
	private static ArrayList<IRunnable> list = new ArrayList<IRunnable>();
	private static EventHandler<ActionEvent> e;
	
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
	}
	
}
