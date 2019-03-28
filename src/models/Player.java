package models;

import gui.Display;

public class Player{
    private int x;
    private int y;
    private int[] position;
    private String orientation;
    private boolean hitEnd;
    private Display ui;
    private Field field;
    private Pocket pocket;
    private Game game;


    public Player(Display ui, Field field, Game game){
        this.x = 0;
        this.y = 0;
        this.position = new int[]{x, y};
        this.orientation = "down";
        this.hitEnd = false;
        this.ui = ui;
        this.field = field;
        this.pocket = new Pocket();
        this.game = game;
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
        if(this.hitEnd)
            game.levelEnd();

        //TODO: adding orientation to this when we finally get the gui to work properly
    }

    private boolean moveIsPossible(int[] newPosition){
        if(newPosition[0] >= 0 && newPosition[0] <= 9 && newPosition[1] >= 0 && newPosition[1] <= 9){
            Object tile = field.getTiles()[newPosition[0]][newPosition[1]];
            System.out.println(field.getTiles()[newPosition[0]][newPosition[1]].getType());
            switch(field.getTiles()[newPosition[0]][newPosition[1]].getType()){
                case NORMAL:
                    return field.hitTile(tile);
                case KEY:
                    return field.hitKey(tile, pocket);
                case END:
                    this.hitEnd = true;
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