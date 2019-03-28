package gui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.File;

public class Assets {
    public static BufferedImage grass, key, player, solidWall, door, end;
    public static Clip walk, lock, victory, wall;
    public static void init(){
        grass = ImageLoader.loadImage("/tiles/grassBlock.png");
        key = ImageLoader.loadImage("/tiles/sleutel.jpg");
        player = ImageLoader.loadImage("/tiles/amaru.png");
        solidWall = ImageLoader.loadImage("/tiles/SolidWall.jpg");
        door = ImageLoader.loadImage("/tiles/Door.jpg");
        end = ImageLoader.loadImage("/tiles/end.jpg");
        walk = SoundLoader.loadSound("res/sounds/dirt.wav");
        lock = SoundLoader.loadSound("res/sounds/lock.wav");
        victory = SoundLoader.loadSound("res/sounds/victory.wav");
        wall = SoundLoader.loadSound("res/sounds/wall.wav");

    }

}
