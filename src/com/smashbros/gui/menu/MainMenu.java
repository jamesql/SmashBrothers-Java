package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MainMenu extends Menu {
    ImageView bg = new ImageView(Engine.readImage("menubg.png"));
    private static Pane p = new Pane();

    public MainMenu() {
        Engine.makeScene(p);
        MenuButton btn = new MenuButton("start");
        p.getChildren().add(bg);
        p.getChildren().add(btn.getGraphic());
    }

}
