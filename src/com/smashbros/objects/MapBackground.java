package com.smashbros.objects;
import com.smashbros.engine.Config;
import com.smashbros.engine.Overlay;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MapBackground extends Overlay {
    String ln;
    private int x;
    private int y; 
    private Image i;
    private ImageView bg;

    public MapBackground(String levelName, double windowX, double windowY) {
        super(levelName);
        this.ln = levelName;
        this.x = 0;
        this.y = 0;
        this.i = fetchImg();
        this.bg = new ImageView(i);
        bg.maxHeight(windowY);
        bg.setFitWidth(windowX); 
        SpriteList.add(this.bg);
        this.addNodesToEngine();
        bg.toBack();
    }

    private Image fetchImg(){
        try {
            return new Image(new FileInputStream("src\\com\\smashbros\\assets\\background.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ImageView getImg() {
        return this.bg;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
}
