package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.scene.image.ImageView;

public class MainMenu extends Menu {
    private ImageView splashscreen = new ImageView(Engine.readImage("menubg.png"));
    public MainMenu() {
        super();
        MenuButton btn = new MenuButton("start");
        this.addMenuNode(splashscreen);
        this.addMenuNode(btn.getGraphic());
    }

}
