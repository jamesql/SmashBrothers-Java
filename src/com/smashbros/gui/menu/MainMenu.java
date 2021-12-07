package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MainMenu extends Menu {
    ImageView bg = new ImageView(Engine.readImage("menubg.png"));
    ImageView button = new ImageView(Engine.readImage("startbutton.png"));;
    private static Pane p = new Pane();
    private static Scene mainMenuScene = Engine.makeScene(p);
    public MainMenu() {
        button.setFitWidth(300);
        button.setFitHeight(100);
        button.setX(495);
        button.setY(575);
        button.setOnMouseClicked(Menu.toNextScene);
        p.getChildren().add(bg);
        p.getChildren().add(button);
    }

    public static Scene getScene() {
        return mainMenuScene;
    }

}
