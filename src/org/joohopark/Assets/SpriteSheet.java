package org.joohopark.Assets;

import java.awt.image.BufferedImage;

public class SpriteSheet {

    private BufferedImage sheet;

    protected SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }

    protected BufferedImage crop(int x, int y, int size){
        return sheet.getSubimage(x, y, size, size);
    }

    protected BufferedImage crop(int x, int y, int width, int height){
        return sheet.getSubimage(x, y, width, height);
    }

}
