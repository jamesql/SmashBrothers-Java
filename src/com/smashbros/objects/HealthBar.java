package com.smashbros.objects;
import com.smashbros.interfaces.IDrawable;
import com.smashbros.engine.*;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HealthBar extends Overlay implements IDrawable {
    private Text perc = new Text();
    private Pane root;
    private ArrayList<Rectangle> lives = new ArrayList<>();
    private Character c;
    private int x;
    private int y;
    private static int hbCount = 0;
    private ArrayList<Node> NodeList = new ArrayList<>();
    
    public HealthBar(Character c) {
        super("Hb");
        this.c = c;
        this.root = Engine.getPane();
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
        for (int i = 0; i < c.getLives(); i++) {
            Rectangle r = new Rectangle(20., 20.);
            r.setFill(c.colorHealthIndicator());
            this.lives.add(r);
        }
    }

    public void checkLives() {
        if(lives.size() > c.getLives()) {
            lives.get(lives.size()-1).setVisible(false);
        }
    }

    private void addNodes() {
        for(Node nd : lives) {
            n.add(nd);
        }

        n.add(perc);
    }

    public void checkOrderHB() {
        if(getHbCount() == 1) {
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

    public ArrayList<Rectangle> getRect() {
        return lives;
    }

    @Override
    public void draw() {
        setPercInterval();
        checkLives();
    }

}
