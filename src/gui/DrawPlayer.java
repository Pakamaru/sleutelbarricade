package gui;

import javax.swing.*;
import java.awt.*;

public class DrawPlayer extends JComponent{
    private int[] position;
    private int width;
    private int height;
    public DrawPlayer(int[] position){
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public void paint(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(80, 80, 900, 79);
    }
}
