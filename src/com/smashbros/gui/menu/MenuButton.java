package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MenuButton {
    private ImageView buttonImg;
    private String type;
    private int x;
    private int y;
    public MenuButton(String type) {
        this.type = type;
        this.buttonImg = new ImageView(Engine.readImage(String.format("%sbutton.png", type)));
        buttonImg.setOnMouseClicked(next);
        buttonImg.setOnMousePressed(active);
        buttonImg.setFitWidth(300);
        buttonImg.setFitHeight(100);
        setPos();
    }
    
    private void setPos() {
        switch(this.type) {
            case "start":
                this.x = 495;
                this.y = 575;
                buttonImg.setX(x);
                buttonImg.setY(y);
                break;
            case "next":
                this.x = 950;
                this.y = 575;
                buttonImg.setX(x);
                buttonImg.setY(y);
                break;
            default: 
                break;
                
        }
    }

    private EventHandler<MouseEvent> active = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            buttonImg.setImage(Engine.readImage(String.format("%sbuttonpressed.png", type)));
        }
        
    };

    private EventHandler<MouseEvent> next = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            Engine.nextScene();   
        }
        
    };

    protected EventHandler<MouseEvent> startGame  = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            Engine.setMap();
        }
        
    };

    public ImageView getGraphic() {
        return buttonImg; 
    }
}
