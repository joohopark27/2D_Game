package org.joohopark.Assets;

import org.joohopark.Util.Util;

import java.awt.image.BufferedImage;

public class Tiles {

    private static BufferedImage tileSheet;

    public static BufferedImage one, two, three, four;

    public static void init(){

        SpriteSheet tileSheet = new SpriteSheet(Util.getSheet("res/TileSheet"));

        one = tileSheet.crop(0, 0, 32);
        two = tileSheet.crop(32, 0, 32);
        three = tileSheet.crop(64, 0, 32);
        four = tileSheet.crop(96, 0, 32);

    }

}
