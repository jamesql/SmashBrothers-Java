package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public abstract class Menu {
	
    protected static EventHandler<MouseEvent> toNextScene = new EventHandler<MouseEvent>() {
        public void handle(MouseEvent e)
        {
            Engine.nextScene();
        }
    };
	
}
