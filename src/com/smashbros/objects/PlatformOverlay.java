package com.smashbros.objects;

import com.smashbros.engine.Config;
import com.smashbros.engine.Engine;
import com.smashbros.engine.Overlay;
import com.smashbros.enums.EndBlocks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;

public class PlatformOverlay extends Overlay {
	private String map = Config.instance().get("currentMap");
	private PlatformBlock block;
	private EndBlocks type;
	private Image middleImg;
	private Image endImg;
	private ImageView blockImg;
	
	public PlatformOverlay(PlatformBlock p) {
		super("blockOverlay");
		this.block = p;
		this.x = p.getX();
		this.y = p.getY();
		readImages();
		this.blockImg = new ImageView(middleImg);
		blockImg.setRotationAxis(Rotate.Y_AXIS);
		blockImg.setFitHeight(block.getHeight());
		blockImg.setFitWidth(block.getWidth());

		setPos();
		
		spriteList.add(this.blockImg);
		this.addNodesToEngine();
	}
	
	public void setBlockType(EndBlocks type) {
		this.type = type;
		switch(this.type) {
		case LEFTEND:
			blockImg.setImage(endImg);
			break;
		case RIGHTEND:
			blockImg.setImage(endImg);
			blockImg.setRotate(180);
			break;
		case MIDDLE:
				break;
		}
	}
	
	public void readImages() {
		// haven't made the other blocks yet
		this.middleImg = Engine.readImage(String.format("mapblock-%s-middle.png", map));
		this.endImg = Engine.readImage(String.format("mapblock-%s-end.png", map));
	}
	
	private void setPos() {
		blockImg.setX(block.getX());
		blockImg.setY(block.getY());
	}
	

	@Override
	public void render() {
		// unused, add moving platforms cuz
	}
}
