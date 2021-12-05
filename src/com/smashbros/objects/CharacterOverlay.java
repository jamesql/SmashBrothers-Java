package com.smashbros.objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.smashbros.engine.Overlay;
import com.smashbros.enums.Direction;
import com.smashbros.interfaces.IDrawable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class CharacterOverlay extends Overlay implements IDrawable{
    private int x,y; 
    private Image fullchar;
    private Image icon;
    private ImageView sprite;
    private Character c;

    public CharacterOverlay(Character c) {
        super("sprite");
        this.c = c;
        this.x = c.getX();
        this.y = c.getY();
        this.fullchar = fetchImg();
        this.icon = fetchIcon();
        this.sprite = new ImageView(fullchar);
        SpriteList.add(this.sprite);
        sprite.setRotationAxis(Rotate.Y_AXIS);
        sprite.setFitHeight(50);
        sprite.setFitWidth(50);
        
        this.addNodesToEngine();
    }

    private Image fetchImg(){
        try {
            return new Image(new FileInputStream("src\\com\\smashbros\\assets\\placeholderChar.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Image fetchIcon() {
        try {
            return new Image(new FileInputStream("src\\com\\smashbros\\assets\\placeholderCharHB.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ImageView getImg() {
        return sprite;
    }

    public Image getIcon() {
        return icon;
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

