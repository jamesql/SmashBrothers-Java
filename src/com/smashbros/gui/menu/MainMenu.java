package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MainMenu extends Menu {
    ImageView bg = new ImageView(Engine.readImage("menubg.png"));

    public MainMenu() {
        super();
        MenuButton btn = new MenuButton("start");
        this.addMenuNode(bg);
        this.addMenuNode(btn.getGraphic());
    }

}
