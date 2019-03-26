package gui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.image.BufferedImage;
import java.io.File;

public class Assets {
    public static BufferedImage grass, key, player, solidWall, door, end;
    public static Clip walk;
    public static void init(){
        grass = ImageLoader.loadImage("/tiles/grassBlock.png");
        key = ImageLoader.loadImage("/tiles/sleutel.jpg");
        player = ImageLoader.loadImage("/tiles/mario.png");
        solidWall = ImageLoader.loadImage("/tiles/SolidWall.jpg");
        door = ImageLoader.loadImage("/tiles/Door.jpg");
        end = ImageLoader.loadImage("/tiles/end.jpg");
        //sound effects
        File f = new File("res/sounds/dirt.wav");
        walk = SoundLoader.loadSound(f);
    }

}
