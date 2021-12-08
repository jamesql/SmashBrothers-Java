package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public abstract class Menu {

    protected static EventHandler<MouseEvent> toNextScene(ImageView iv) { 
        return new EventHandler<MouseEvent>() {
            public void handle(MouseEvent e)
            {
                iv.setImage(Engine.readImage("startbuttonpressed.png"));
                Engine.nextScene();
            }
        };
    }
	
}
