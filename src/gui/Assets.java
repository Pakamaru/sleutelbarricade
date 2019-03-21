package gui;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage grass, key;
    public static void init(){
        grass = ImageLoader.loadImage("/tiles/grassBlock.png");
        key = ImageLoader.loadImage("/tiles/sleutel.jpg");
    }

}
