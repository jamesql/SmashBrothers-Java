package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class CharacterSelect extends Menu {
    ImageView bg;
    ImageView button;
    private static Pane p = new Pane();
    private static Scene mainMenuScene = Engine.makeScene(p);
    public CharacterSelect() {
        bg = new ImageView(Engine.readImage("bgclean.png"));
        button = new ImageView(Engine.readImage("startbutton.png"));
        button.setFitWidth(300);
        button.setFitHeight(100);
        button.setX(950);
        button.setY(575);
        button.setOnMouseClicked(Menu.toNextScene);
        p.getChildren().add(bg);
        p.getChildren().add(button);
    }

    public static Scene getScene() {
        return mainMenuScene;
    }

}
