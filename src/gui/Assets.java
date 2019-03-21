package gui;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage grass, key, player, barrier, end, wall;
    public static void innit(){
        grass = ImageLoader.loadImage("res/grassBlock.png");
        key = ImageLoader.loadImage("res/sleutel.jpg");
    }

}
