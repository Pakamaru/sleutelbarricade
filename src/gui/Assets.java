package gui;

import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage grass, key, player, solidWall, door, end;
    public static void init(){
        grass = ImageLoader.loadImage("/tiles/grassBlock.png");
        key = ImageLoader.loadImage("/tiles/sleutel.jpg");
        player = ImageLoader.loadImage("/tiles/mario.png");
        solidWall = ImageLoader.loadImage("/tiles/SolidWall.jpg");
        door = ImageLoader.loadImage("/tiles/Door.jpg");
        end = ImageLoader.loadImage("/tiles/end.jpg");
    }

}
