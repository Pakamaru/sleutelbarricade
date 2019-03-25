package models;

import gui.Display;

public class Player {
    private int x;
    private int y;
    private int[] position = {x, y};
    private String orientation;
    private Display ui;
    private Field field;


    public Player(Display ui, Field field){
        this.x = 0;
        this.y = 0;
        this.orientation = "down";
        this.ui = ui;
        this.field = field;
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
        System.out.println(x+" - "+y);
        ui.drawPlayer(position); //TODO: adding orientation to this when we finally get the gui to work properly
    }

    /*
    TODO: Add some more movement validations using the Field class. blah blah blah you know what to do with that big fat butt...
     */
    private boolean moveIsPossible(int[] newPosition){
        if(newPosition[0] >= 0 && newPosition[0] <= 10 && newPosition[1] >= 0 && newPosition[1] <= 10){
            switch(field.getTiles()[newPosition[0]][newPosition[1]].getType()){
                case "tile":
                    System.out.println("HIT: tile");
                    return true;
                case "key":
                    System.out.println("HIT: key");
                    return true;
                case "end":
                    System.out.println("HIT: end");
                    return true;
                case "barrier":
                    System.out.println("HIT: barrier");
                    return false;
                case "wall":
                    System.out.println("HIT: wall");
                    return false;
            }
        }
        return false;
    }

    public int[] getPosition(){
        return position;
    }
}