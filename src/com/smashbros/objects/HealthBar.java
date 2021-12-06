package com.smashbros.objects;

import java.util.ArrayList;

import com.smashbros.engine.Overlay;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class HealthBar extends Overlay {
	private Character c;
	private Text perc = new Text();
	private ArrayList<ImageView> lives = new ArrayList<ImageView>();
	private static int hbCount = 0;
	private int hbIndex;
	
	public HealthBar(Character c) {
		super("Hb");
		this.c = c;
		this.hbIndex = ++hbCount;
	}

	public void setLives() {
		// finish char over lay first
	}

	public void updateLives() {

	}

	public void updateHealth() {
		perc.setText(String.valueOf(c.getHealth()) + "%");
		perc.setFill(c.colorHealthIndicator());
	}

	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
		setLivesPos();
		setHealthPercentPos();
	}

	private void setLivesPos() {
		for (int i = 0; i < lives.size(); i++) {
			lives.get(i).setX(this.x + (i * 50.));
			lives.get(i).setY(this.y + 20.);
		}
	}

	private void setHealthPercentPos() {
		perc.setX(this.x);
		perc.setY(this.y);
	}

	// TODO : OverlayList.getNumHealthbars(); : int
	public void setHealthBarPos() {

	}

	@Override
	public void render() {
		updateLives();
		updateHealth();
	}

}
