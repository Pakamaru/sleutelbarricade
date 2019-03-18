package gui;

import models.Field;
import models.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Graph extends JComponent{
    private int [][] myGraph = new int[10][10];
    private Tile[][] tiles;
    private BufferedImage grass = ImageIO.read(new File("res/grassBlock.png"));
    private BufferedImage sleutel = ImageIO.read(new File("res/sleutel.jpg"));

    public Graph(Field field) throws IOException{
        this.tiles = field.getTiles();
    }
    public void paintComponent(Graphics g){
        for (int i = 0; i<myGraph.length; i++){
            for (int j = 0; j<myGraph[i].length; j++){
                switch (tiles[i][j].getType()){
                    case 0: g.drawImage(grass, 80*i, 80*j, 79, 79, null);
                        break;
                    case 3: g.drawImage(sleutel, 80*i, 80*j, 79, 79, null);
                        break;
                }

            }
        }
    }
}