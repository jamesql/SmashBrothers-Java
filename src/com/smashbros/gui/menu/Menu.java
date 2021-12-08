package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public abstract class Menu {
	protected Pane menuPane = new Pane();
    protected ImageView bg = new ImageView(Engine.readImage("bgclean.png"));
    protected Menu() {
        Engine.makeScene(menuPane);
        addMenuNode(bg);
    }

    protected void addMenuNode(Node n) {
        menuPane.getChildren().add(n);
    }

}