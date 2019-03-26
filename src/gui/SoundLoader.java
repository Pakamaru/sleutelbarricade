package gui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundLoader {
    public static Clip loadSound(File f){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            return clip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
