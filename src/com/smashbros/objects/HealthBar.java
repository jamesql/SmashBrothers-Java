package com.smashbros.objects;
import com.smashbros.interfaces.IDrawable;
import com.smashbros.engine.*;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HealthBar extends Overlay implements IDrawable {
    private Text perc = new Text();
    private ArrayList<ImageView> lives = new ArrayList<>();
    private Character c;
    private int x;
    private int y;
    private static int hbCount = 0;
    
    public HealthBar(Character c) {
        super("Hb");
        this.c = c;
        addHbCount();
        setLives();
        setPercInterval();
        perc.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        perc.setX(0);
        perc.setY(0);
        checkOrderHB();
        addNodes();
        this.addNodesToEngine();
    }

    private static void addHbCount() {
        hbCount += 1;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
        setPercPos();
        setRectPos();
    }

    public void setRectPos() {
        for(int i = 0; i < lives.size(); i++) {
            lives.get(i).setX(this.x + (i * 50.));
            lives.get(i).setY(this.y + 20.);
        }
    }

    public void setPercPos() {
        perc.setX(this.x);
        perc.setY(this.y);
    }

    public void setPercInterval() {
        perc.setText(String.valueOf(c.getHealth()) + "%");
        perc.setFill(c.colorHealthIndicator());
    }

    public void setLives() {
        Image icon = c.getCharOverlay().getIcon();
        for (int i = 0; i < c.getLives(); i++) {
            ImageView tempIV = new ImageView(icon);
            tempIV.setFitHeight(40.);
            tempIV.setFitWidth(40.);
            this.lives.add(tempIV);
        }
    }

    public void checkLives() {
        if(lives.size() > c.getLives()) {
            lives.get(lives.size()-1).setVisible(false);
            lives.remove(lives.size()-1);
        }
    }

    private void addNodes() {
        for(ImageView nd : lives) {
            overlayNodeList.add(nd);
        }

        overlayNodeList.add(perc);
    }

    public void checkOrderHB() {
        if(HealthBar.hbCount == 1) {
            setXY(100,575);
        } else {
            setXY(840,575);
        }
    }

    public Text getPerc() {
        return perc;
    }

    public int getHbCount() {
        return hbCount;
    }

    public ArrayList<ImageView> getRect() {
        return lives;
    }

    @Override
    public void draw() {
        setPercInterval();
        checkLives();
    }

}
