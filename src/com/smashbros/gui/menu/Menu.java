package com.smashbros.gui.menu;

import java.util.ArrayList;

import com.smashbros.engine.Engine;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public abstract class Menu {
	protected Pane menuPane = new Pane();
    
    protected Menu() {
        Engine.makeScene(menuPane);
    }

    protected void addMenuNode(Node n) {
        menuPane.getChildren().add(n);
    }

}
