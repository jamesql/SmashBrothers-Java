package com.smashbros.gui.menu;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.smashbros.engine.Config;
import com.smashbros.engine.Engine;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CharacterSelect extends Menu {
    private HBox imageRow = new HBox();
    private ArrayList<ImageView> characterImgs = new ArrayList<ImageView>();
    private ArrayList<String> charNames = new ArrayList<String>(); 
    private MenuButton selectBtn = new MenuButton("select");
   
    // change to private
    public static String currentSelected = "default";
    public static Text curSelect = new Text("Player 1 Selecting");
    public static int playerSelecting = 1;
   
    public CharacterSelect() {
        curSelect.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        curSelect.setX(200);
        curSelect.setY(200);
        this.addMenuNode(curSelect);
        this.addMenuNode(selectBtn.getGraphic());
        curSelect.toFront();
        showChars();
        setOnClickImg();
        setOnClickSelect();
    }

    private void setOnClickImg() {
        for(ImageView i : characterImgs) {
            i.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent e) {
                	ImageView f = (ImageView) e.getSource();
                	String s = f.getImage().getUrl();
                	CharacterSelect.currentSelected = s.substring(s.indexOf("ch-")+3, s.indexOf("."));
                }
            });
        }
    }

    private void setOnClickSelect() {
        selectBtn.getGraphic().setOnMouseReleased(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent e) {

            	if (CharacterSelect.currentSelected.equals("none")) return;
            	            	
            	switch (CharacterSelect.playerSelecting) {
            	case 1:
            		Config.instance().set("char1", CharacterSelect.currentSelected);
            		CharacterSelect.curSelect.setText("Player 2 Selecting");
            		CharacterSelect.playerSelecting++;
            		break;
            	case 2:
            		Config.instance().set("char2", CharacterSelect.currentSelected);
            		Engine.setMap();
            		CharacterSelect.curSelect.setText("Player 1 Selecting");
            		CharacterSelect.playerSelecting = 1;
            		break;
            	}
            	
            	CharacterSelect.currentSelected = "default";
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
                iv.setFitHeight(100);
                iv.setFitWidth(100);
                characterImgs.add(iv);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        imageRow.setSpacing(20);
        imageRow.getChildren().addAll(characterImgs);
        imageRow.setLayoutX(460);
        imageRow.setLayoutY(310);

        this.addMenuNode(imageRow);
    }


}