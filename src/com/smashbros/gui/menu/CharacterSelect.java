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
import javafx.scene.layout.Pane;

public class CharacterSelect extends Menu {
    private static Pane p = new Pane();
    private HBox imageRow = new HBox();
    private ArrayList<ImageView> characterImgs = new ArrayList<ImageView>();
    private ArrayList<String> charNames = new ArrayList<String>(); 

    private Config cfg = Config.instance();

    public CharacterSelect() {
        MenuButton btn = new MenuButton("next");
        p.getChildren().add(btn.getGraphic());
        showChars();
        setOnClick();
    }

    private void setOnClick() {
        for(ImageView i : characterImgs) {
            i.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent arg0) {
                    String fileLoc = i.getImage().getUrl();
                    String charName = fileLoc.substring(fileLoc.indexOf("-")+1, fileLoc.indexOf("."));
                    System.out.println(charName);
                    cfg.set("char1", charName);
                }
            });
        }
    }

    // https://stackoverflow.com/questions/794381/how-to-find-files-that-match-a-wildcard-string-in-java
    private void showChars() {

        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(
            Paths.get("src\\com\\smashbros\\assets"), "ch-*.png")) {
            dirStream.forEach(path ->  {
                ImageView iv = new ImageView(path.toFile().toURI().toString());
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
