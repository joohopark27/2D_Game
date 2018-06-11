package org.joohopark.Assets;

import org.joohopark.Util.Util;

import java.awt.image.BufferedImage;

public class Tiles {

    private static BufferedImage one, two, three, four;

    public static void init(){

        SpriteSheet tileSheet = new SpriteSheet(Util.getSheet("res/TileSheet.png"));

        one = tileSheet.crop(0, 0, 32);
        two = tileSheet.crop(32, 0, 32);
        three = tileSheet.crop(64, 0, 32);
        four = tileSheet.crop(96, 0, 32);

    }

    public static BufferedImage getTile(int num){
        switch (num){
            case 1:
                return one;
            case 2:
                return two;
            case 3:
                return three;
            case 4:
                return four;
            default:
                return null;
        }
    }

}
