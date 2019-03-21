package models;

public class Player {
    private int x;
    private int y;
    private int[] position = {x, y};


    public Player(){
        this.x = 0;
        this.y = 0;
    }

    public void move(String direction){
        System.out.println(direction);
    }

    public int[] getPosition(){
        return position;
    }
}