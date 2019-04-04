package gui;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Helps with loading images
 */

public class ImageLoader {
    public static BufferedImage loadImage(String path) {
        try {
            File f = new File(path);
            return ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
