package gui;


import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage grass, key, player, solidWall, door, end;
    public static Clip walk, lock, victory, wall;
    public static void init(){
        grass = ImageLoader.loadImage("res/tiles/grass.png");
        key = ImageLoader.loadImage("res/tiles/sleutel.png");
        player = ImageLoader.loadImage("res/tiles/amaruPix.png");
        solidWall = ImageLoader.loadImage("res/tiles/wall.png");
        door = ImageLoader.loadImage("res/tiles/deur.png");
        end = ImageLoader.loadImage("res/tiles/Open.png");
        walk = SoundLoader.loadSound("res/sounds/dirt.wav");
        lock = SoundLoader.loadSound("res/sounds/lock.wav");
        victory = SoundLoader.loadSound("res/sounds/victory.wav");
        wall = SoundLoader.loadSound("res/sounds/wall.wav");

    }

}
