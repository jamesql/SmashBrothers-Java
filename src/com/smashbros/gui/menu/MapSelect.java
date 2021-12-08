package com.smashbros.gui.menu;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.smashbros.engine.Config;
import com.smashbros.engine.Engine;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MapSelect extends Menu {
    private ImageView bg;
    private HBox imageRow = new HBox();
    private static Pane p = new Pane();
    Config cfg = Config.instance();

    public MapSelect() {
        Engine.makeScene(p);
        this.bg = new ImageView(Engine.readImage("bgclean.png"));
        MenuButton btn = new MenuButton("next");
        p.getChildren().add(bg);
        p.getChildren().add(btn.getGraphic());
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

        imageRow.setSpacing(20);
        imageRow.getChildren().addAll(i);
        imageRow.setLayoutX(374);
        imageRow.setLayoutY(278);

        p.getChildren().add(imageRow);
    }

}
