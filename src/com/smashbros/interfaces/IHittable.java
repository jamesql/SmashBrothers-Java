package com.smashbros.interfaces;

import javafx.scene.paint.Color;

public interface IHittable {
    public void setLives(int l);
    
    public int getLives();

    public void setHealth(int h);

    public int getHealth();

    public Color colorHealthIndicator();
    
    public boolean isAttacking();
    
    public void die();
}
