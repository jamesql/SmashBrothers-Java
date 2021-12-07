package com.smashbros.gui.menu;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.smashbros.engine.Engine;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MapSelect extends Menu {
    ImageView bg;
    ImageView map1;
    ImageView map2;
    ImageView button;
    private static Pane p = new Pane();

    public MapSelect() {
        Scene mainMenuScene = Engine.makeScene(p);
        bg = new ImageView(Engine.readImage("bgclean.png"));
        button = new ImageView(Engine.readImage("nextbutton.png"));
        button.setFitWidth(300);
        button.setFitHeight(100);
        button.setOnMouseClicked(Menu.toNextScene);
        button.setX(950);
        button.setY(575);
        p.getChildren().add(bg);
        p.getChildren().add(button);
        showMaps();
    }

    // https://stackoverflow.com/questions/794381/how-to-find-files-that-match-a-wildcard-string-in-java
    public void showMaps() {
        ArrayList<ImageView> i = new ArrayList<ImageView>();

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(
            Paths.get("src\\com\\smashbros\\assets"), "map-vpw*.png")) {
            dirStream.forEach(path ->  {
                ImageView iv = new ImageView(path.toFile().toURI().toString());
                iv.setFitHeight(144);
                iv.setFitWidth(256);
                i.add(iv);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        HBox imageRow = new HBox();
        imageRow.setSpacing(20);
        imageRow.getChildren().addAll(i);

        p.getChildren().add(imageRow);
    }

}
