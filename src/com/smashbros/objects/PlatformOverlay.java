package com.smashbros.objects;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.smashbros.engine.Overlay;
import com.smashbros.enums.EndBlocks;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;


public class PlatformOverlay extends Overlay{
    private static String middleLoc = "src\\com\\smashbros\\assets\\block.png";
    private static String endLoc = "src\\com\\smashbros\\assets\\endBlock.png";
    private Image middleblock = fetchImg(middleLoc);
    private Image endblock = fetchImg(endLoc);
    private ImageView blockimg;
    private int x;
    private int y;
    private PlatformBlock block;

    public PlatformOverlay(PlatformBlock p) {
        super("blockOverlay");
        this.block = p;
        this.x = block.getX();
        this.y = block.getY();
        this.blockimg = new ImageView(middleblock);
        blockimg.setRotationAxis(Rotate.Y_AXIS);
        blockimg.setFitHeight(block.getH());
        blockimg.setFitWidth(block.getW());
        setXY();
        SpriteList.add(this.blockimg);
        this.addNodesToEngine();
    }


    private Image fetchImg(String loc) {
        try {
            return new Image(new FileInputStream(loc));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ImageView getImg() {
        return blockimg;
    }

    public void setEndBlockImg(Enum endCase) {
        if(endCase.equals(EndBlocks.LEFTEND)) {
            blockimg.setImage(endblock);
        } else if(endCase.equals(EndBlocks.RIGHTEND)) {
            blockimg.setImage(endblock);
            blockimg.setRotate(180);
        }
    }

    private void setXY() {
        blockimg.setX(block.getX());
        blockimg.setY(block.getY());
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
