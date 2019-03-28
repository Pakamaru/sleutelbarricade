package gui;


import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage grass, key, player, solidWall, door, end;
    public static Clip walk, lock, victory, wall;
    public static void init(){
        grass = ImageLoader.loadImage("res/tiles/grassBlock.png");
        key = ImageLoader.loadImage("res/tiles/sleutel.jpg");
        player = ImageLoader.loadImage("res/tiles/amaru.png");
        solidWall = ImageLoader.loadImage("res/tiles/SolidWall.jpg");
        door = ImageLoader.loadImage("res/tiles/Door.jpg");
        end = ImageLoader.loadImage("res/tiles/end.jpg");
        walk = SoundLoader.loadSound("res/sounds/dirt.wav");
        lock = SoundLoader.loadSound("res/sounds/lock.wav");
        victory = SoundLoader.loadSound("res/sounds/victory.wav");
        wall = SoundLoader.loadSound("res/sounds/wall.wav");

    }

}
