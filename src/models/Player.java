package models;

import gui.Display;

public class Player {
    private int x;
    private int y;
    private int[] position = {x, y};
    private String orientation;
    private Display ui;
    private Field field;
    private Pocket pocket;


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
        System.out.println(x+" - "+y);
        ui.drawPlayer(position); //TODO: adding orientation to this when we finally get the gui to work properly
    }

    /*
    TODO: Add some more movement validations using the Field class. blah blah blah you know what to do with that big fat butt...
     */
    private boolean moveIsPossible(int[] newPosition){
        if(newPosition[0] >= 0 && newPosition[0] <= 10 && newPosition[1] >= 0 && newPosition[1] <= 10){
            Object tile = field.getTiles()[newPosition[0]][newPosition[1]];
            switch(field.getTiles()[newPosition[0]][newPosition[1]].getType()){
                case "tile":
                    return hitTile(tile);
                case "key":
                    return hitKey(tile);
                case "end":
                    return hitEnd(tile);
                case "barrier":
                    return hitBarrier(tile);
                case "wall":
                    return hitWall(tile);
            }
        }
        return false;
    }

    public boolean hitWall(Object tile){
        SolidWall wallTile = (SolidWall) tile;
        return false;
    }
    public boolean hitBarrier(Object tile){
        Barrier barrierTile = (Barrier) tile;
        if(this.pocket.getKey().getNumber() == barrierTile.getNumber()){
            System.out.println("Opened lock!!");
            return true;
        }
        return false;
    }
    public boolean hitKey(Object tile){
        KeyTile keyTile = (KeyTile) tile;
        this.pocket.setKey(keyTile.getKey());
        System.out.println(this.pocket.getKey().getNumber());
        return true;
    }
    public boolean hitTile(Object tile){
        Tile normalTile = (Tile) tile;
        System.out.println("INSERT WALK SOUND");
        return true;
    }
    public boolean hitEnd(Object tile){
        EndTile endTile = (EndTile) tile;
        return false;
    }

    public int[] getPosition(){
        return position;
    }

    public String getOrientation() {
        return orientation;
    }
}