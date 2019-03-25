package gui;

import javax.swing.*;
import java.awt.*;

public class DrawPlayer extends JComponent{
    //private int[] position;
    private int x;
    private int y;
    private int width;
    private int height;
    public DrawPlayer(int x, int y){
        this.x = x;
        this.y = y;

    }
    public void refreshPlayer(Graphics g){
        g.drawImage(Assets.player, 80*x,80*y, 79, 79, null);
    }


}
