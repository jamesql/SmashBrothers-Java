package com.smashbros.gui.menu;

import com.smashbros.engine.Engine;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MenuButton {
    private ImageView buttonImg;
    private String type;

    public MenuButton(String type) {
        this.type = type;
        this.buttonImg = new ImageView(Engine.readImage(String.format("%sbutton.png", type)));
        buttonImg.addEventHandler(MouseEvent.MOUSE_PRESSED, active);
        buttonImg.addEventHandler(MouseEvent.MOUSE_RELEASED, normal);
        buttonImg.addEventHandler(MouseEvent.MOUSE_RELEASED, next);
        buttonImg.setFitWidth(300);
        buttonImg.setFitHeight(100);
        setPos();
    }
    
    private void setPos() {
        int[] xpos = {30,495,950};
        int y = 575;
        switch(this.type) {
            case "start":
                buttonImg.setX(xpos[1]);
                buttonImg.setY(y);
                break;
            case "next":
                buttonImg.setX(xpos[2]);
                buttonImg.setY(y);
                break;
            case "select":
                buttonImg.setX(xpos[0]);
                buttonImg.setY(y);
                buttonImg.removeEventHandler(MouseEvent.MOUSE_RELEASED, next);
                break;
            case "done":
                buttonImg.setX(xpos[2]);
                buttonImg.setY(y);
                buttonImg.addEventFilter(MouseEvent.MOUSE_RELEASED, startGame);
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

    private EventHandler<MouseEvent> normal = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            buttonImg.setImage(Engine.readImage(String.format("%sbutton.png", type)));
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
