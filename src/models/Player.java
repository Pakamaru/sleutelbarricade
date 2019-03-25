package models;

import gui.Assets;
import gui.Display;
import models.tiles.*;

import javax.swing.*;
import java.awt.*;

public class Player extends JComponent {
    private int x;
    private int y;
    private int[] position = {x, y};
    private String orientation;
    private Display ui;
    private Field field;
    private Pocket pocket;
    private Graphics g;


    public Player(Display ui, Field field){
        this.x = 0;
        this.y = 0;
        this.orientation = "down";
        this.ui = ui;
        this.field = field;
        this.pocket = new Pocket();
    }

    public void move(String direction){
        if(direction.equals("none"))
            return;
        switch(direction){
            case "up": if(moveIsPossible(new int[]{this.position[0], this.position[1]-1})){ this.y--; }
                this.orientation = "up";
                break;
            case "down": if(moveIsPossible(new int[]{this.position[0], this.position[1]+1})){ this.y++; }
                this.orientation = "down";
                break;
            case "left": if(moveIsPossible(new int[]{this.position[0]-1, this.position[1]})){ this.x--; }
                this.orientation = "left";
                break;
            case "right": if(moveIsPossible(new int[]{this.position[0]+1, this.position[1]})){ this.x++; }
                this.orientation = "right";
                break;
        }
        this.position[0] = x;
        this.position[1] = y;
        ui.showField(field, position[0], position[1]);
        System.out.println(x+" - "+y);

        //TODO: adding orientation to this when we finally get the gui to work properly
    }

    /*
    TODO: Add some more movement validations using the Field class. blah blah blah you know what to do with that big fat butt...
     */
    private boolean moveIsPossible(int[] newPosition){
        if(newPosition[0] >= 0 && newPosition[0] <= 9 && newPosition[1] >= 0 && newPosition[1] <= 9){
            Object tile = field.getTiles()[newPosition[0]][newPosition[1]];
            switch(field.getTiles()[newPosition[0]][newPosition[1]].getType()){
                case NORMAL:
                    return field.hitTile(tile);
                case KEY:
                    return field.hitKey(tile, pocket);
                case END:
                    return field.hitEnd(tile);
                case BARRIER:
                    return field.hitBarrier(tile, this.pocket.getKey().getNumber());
                case WALL:
                    return field.hitWall(tile);
            }
        }
        return false;
    }

    public int[] getPosition(){
        return position;
    }

    public String getOrientation() {
        return orientation;
    }
}