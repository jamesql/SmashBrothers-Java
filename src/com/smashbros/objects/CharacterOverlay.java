package com.smashbros.objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.smashbros.engine.Overlay;
import com.smashbros.enums.Direction;
import com.smashbros.interfaces.IDrawable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class CharacterOverlay extends Overlay implements IDrawable{
    private int x,y; 
    private Image i;
    private ImageView sprite;
    private Character c;
    private ArrayList<ImageView> CharacterSprites;

    public CharacterOverlay(Character c) {
        super("sprite");
        this.c = c;
        this.x = c.getX();
        this.y = c.getY();
        this.i = makeImg();
        this.sprite = new ImageView(i);
        SpriteList.add(this.sprite);
        sprite.setRotationAxis(Rotate.Y_AXIS);
        sprite.setFitHeight(50);
        sprite.setFitWidth(50);
        
        this.addNodesToEngine();
    }

    private Image makeImg(){
        try {
            return new Image(new FileInputStream("img\\placeholderChar.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ImageView getImg() {
        return sprite;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    private void checkDir() {
        if(c.getDir() == Direction.LEFT) {
            sprite.setRotate(180);
        } else if(c.getDir() == Direction.RIGHT) {
            sprite.setRotate(0);
        }
    }

    public void moveImg() {
        sprite.setX(c.getX());
        sprite.setY(c.getY());  
        checkDir();
    }

    @Override
    public void draw() {
        moveImg();
    }
}

