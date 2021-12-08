package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CharacterSelect extends Menu {
    private ImageView bg;
    private static Pane p = new Pane();
    
    public CharacterSelect() {
        Engine.makeScene(p);
        bg = new ImageView(Engine.readImage("bgclean.png"));
        MenuButton btn = new MenuButton("next");
        p.getChildren().add(bg);
        p.getChildren().add(btn.getGraphic());
    }


}
