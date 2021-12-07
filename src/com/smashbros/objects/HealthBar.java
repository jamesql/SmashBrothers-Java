
package com.smashbros.objects;

import java.util.ArrayList;

import com.smashbros.engine.Overlay;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
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
		
		setLives();
		updateHealth();
		
		perc.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		perc.setX(0);
		perc.setY(0);
		
		setHealthBarPos();
		addNodes();
		
		this.addNodesToEngine();
	}

	public void setLives() {
		Image icon = this.c.getOverlay().getIcon();
		for (int i = 0; i < c.getLives(); i++) {
			ImageView temp = new ImageView(icon);
			temp.setFitHeight(40.);
			temp.setFitWidth(40.);
			this.lives.add(temp);
		}
	}

	public void updateLives() {
		if (lives.size() > c.getLives()) {
			lives.get(lives.size()-1).setVisible(false);
			lives.remove(lives.size()-1);
		}
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

	public void setHealthBarPos() {
		
		int[][] pos = {{50,100}, {1080, 100}, {50, 600}, {1080, 600}};
		
		if (hbCount == 1) 
			setPos(pos[0][0],pos[0][1]);
			else setPos(pos[1][0],pos[1][1]);
	}
	
	public void addNodes() {
		for (ImageView n : lives)
			this.overlayNodeList.add(n);
		
		overlayNodeList.add(perc);
	}

	@Override
	public void render() {
		updateLives();
		updateHealth();
	}
  
}