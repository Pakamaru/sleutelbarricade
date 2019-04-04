package gui;

import models.Field;
import models.tiles.Barrier;
import models.tiles.KeyTile;
import models.tiles.Tile;

import javax.swing.*;
import java.awt.*;

/**
 * Class that creates the tiles and gives specific tiles a certain value.
 */

public class Graph extends JComponent{
    private Tile[][] tiles;
    private int x;
    private int y;

    private static int TILE_WIDTH=79;
    private static int TILE_HEIGHT=79;

    /**
     * Constructor made for the creation of the value of tiles
     * @param field gives a value to graph that lets it draw the field
     * @param x is the value of the horizontal coordinate in the game
     * @param y is the value of the vertical coordinate in the game
     */

    public Graph(Field field, int x, int y){
        this.tiles = field.getTiles();
        this.x = x;
        this.y = y;

    }

    /**
     * Method that paints the tiles in their matching values
     * @param g allows for the creation of graphics
     */
    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Calibri", Font.BOLD, 16));
        for (int i = 0; i<tiles.length; i++){
            for (int j = 0; j<tiles[i].length; j++){
                switch (tiles[i][j].getType()){
                    case PLAYERSTART:
                    case NORMAL: g.drawImage(Assets.grass, 80*i, 80*j, TILE_WIDTH, TILE_HEIGHT, null);
                        break;
                    case KEY: g.drawImage(Assets.key, 80*i, 80*j, TILE_WIDTH, TILE_HEIGHT, null);
                        g.drawString(""+((KeyTile)tiles[i][j]).getKey().getNumber(), 80*i+TILE_WIDTH/4, 80*j+TILE_HEIGHT-5);
                        break;
                    case WALL: g.drawImage(Assets.solidWall, 80*i, 80*j, TILE_WIDTH, TILE_HEIGHT, null);
                        break;
                    case BARRIER: g.drawImage(Assets.door, 80*i, 80*j, TILE_WIDTH, TILE_HEIGHT, null);
                        g.drawString(""+((Barrier)tiles[i][j]).getNumber(), 80*i+TILE_WIDTH/3, 80*j+TILE_HEIGHT-5);
                        break;
                    case END: g.drawImage(Assets.end, 80*i, 80*j, TILE_WIDTH, TILE_HEIGHT, null);
                        break;
                }
            }
        }
        g.drawImage(Assets.player, 80*x,80*y, TILE_WIDTH, TILE_HEIGHT, null);
    }
}
