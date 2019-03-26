package gui;

import javax.swing.*;
import java.awt.*;

public class TextBox extends JComponent {
    private String msg;
    private static int x = 0;
    private static int y = 0;
    private static int FONTSIZE = 20;

    public TextBox(String msg){
        this.msg = msg;
    }

    public void paintComponent(Graphics g){
        g.setFont(new Font("Arial",Font.PLAIN, FONTSIZE));
        g.setColor(new Color(255, 255, 255, 175));
        g.fillRect(x, y, 450, 600);
        g.setColor(new Color(0, 0, 0, 255));

        g.drawString("Hint:", x, FONTSIZE);
        for (String line : msg.split("\n")) {
            int fontsize = FONTSIZE;
            g.drawString(line, x, fontsize += g.getFontMetrics().getHeight());
        }

    }
}
