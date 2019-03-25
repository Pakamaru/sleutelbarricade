package gui;

import models.Field;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;

public class Graph extends JComponent{
    private int [][] myGraph = new int[10][10];
    private Tile[][] tiles;

    private static int TILE_WIDTH=79;
    private static int TILE_HEIGHT=79;

    public Graph(Field field){
        this.tiles = field.getTiles();
    }
    public void paintComponent(Graphics g){
        //g.drawImage(Assets.player, 1000,1000, TILE_WIDTH, TILE_HEIGHT, null);
        for (int i = 0; i<myGraph.length; i++){
            for (int j = 0; j<myGraph[i].length; j++){
                switch (tiles[i][j].getType()){
                    case NORMAL: g.drawImage(Assets.grass, 80*i, 80*j, TILE_WIDTH, TILE_HEIGHT, null);
                        break;
                    case KEY: g.drawImage(Assets.key, 80*i, 80*j, TILE_WIDTH, TILE_HEIGHT, null);
                        break;
                }
            }
        }
    }

    public static int getTileWidth() {
        return TILE_WIDTH;
    }

    public static int getTileHeight() {
        return TILE_HEIGHT;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
