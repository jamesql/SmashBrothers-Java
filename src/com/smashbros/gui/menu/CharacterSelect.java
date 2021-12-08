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

public class CharacterSelect extends Menu {
    private HBox imageRow = new HBox();
    private ArrayList<ImageView> characterImgs = new ArrayList<ImageView>();
    private ArrayList<String> charNames = new ArrayList<String>(); 
    private MenuButton selectBtn = new MenuButton("select");

    private Config cfg = Config.instance();

    public CharacterSelect() {
        MenuButton doneBtn = new MenuButton("done");
        this.addMenuNode(doneBtn.getGraphic());
        this.addMenuNode(selectBtn.getGraphic());
        showChars();
        setOnClickImg();
        setOnClickSelect();
    }

    private void setOnClickImg() {
        for(ImageView i : characterImgs) {
            i.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent arg0) {

                }
            });
        }
    }

    private void setOnClickSelect() {
        selectBtn.getGraphic().setOnMouseReleased(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent arg0) {
                // TODO Auto-generated method stub
                // isSelected();
            }

        });
    }

    // https://stackoverflow.com/questions/794381/how-to-find-files-that-match-a-wildcard-string-in-java
    private void showChars() {

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(
            Paths.get("src/com/smashbros/assets"), "ch-*.png")) {
            dirStream.forEach(path ->  {
                String pathString = path.toFile().toURI().toString();
                String charName = pathString.substring(pathString.indexOf("-")+1, pathString.indexOf("."));
                charNames.add(charName);
                ImageView iv = new ImageView(pathString);
                iv.setFitHeight(144);
                iv.setFitWidth(256);
                characterImgs.add(iv);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        imageRow.setSpacing(20);
        imageRow.getChildren().addAll(characterImgs);
        imageRow.setLayoutX(374);
        imageRow.setLayoutY(278);

        this.addMenuNode(imageRow);
    }


}