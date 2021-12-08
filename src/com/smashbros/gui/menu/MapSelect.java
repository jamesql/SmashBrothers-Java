package com.smashbros.gui.menu;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.smashbros.engine.Config;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
public class MapSelect extends Menu {
    private HBox imageRow = new HBox();
    private ArrayList<ImageView> mapImages = new ArrayList<ImageView>();

    Config cfg = Config.instance();

    public MapSelect() {
        super();
        MenuButton btn = new MenuButton("next");
        this.addMenuNode(btn.getGraphic());
        showMaps();
        setOnClick();
    }

    private void setOnClick() {
        for(ImageView i : mapImages) {
            i.setOnMouseClicked(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent arg0) {
                    String fileLoc = i.getImage().getUrl();
                    String mapName = fileLoc.substring(fileLoc.indexOf("-")+1, fileLoc.indexOf("."));
                    System.out.println(mapName);
                    cfg.set("currentMap", mapName);
                }
            });
        }
    }

    // https://stackoverflow.com/questions/794381/how-to-find-files-that-match-a-wildcard-string-in-java
    private void showMaps() {

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(
            Paths.get("src/com/smashbros/assets"), "map-*.png")) {
            dirStream.forEach(path ->  {
                ImageView iv = new ImageView(path.toFile().toURI().toString());
                iv.setFitHeight(144);
                iv.setFitWidth(256);
                mapImages.add(iv);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        imageRow.setSpacing(20);
        imageRow.getChildren().addAll(mapImages);
        imageRow.setLayoutX(226);
        imageRow.setLayoutY(278);

        this.addMenuNode(imageRow);
    }

}
