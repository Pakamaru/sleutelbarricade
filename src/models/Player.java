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
        if(direction.equals("none"))
            return;
        switch(direction){
            case "up": if(moveIsPossible(y-1)){ this.y--; }
                break;
            case "down": if(moveIsPossible(y+1)){ this.y++; }
                break;
            case "left": if(moveIsPossible(x-1)){ this.x--; }
                break;
            case "right": if(moveIsPossible(x+1)){ this.x++; }
                break;
        }
        System.out.println(x+" - "+y);
    }

    private boolean moveIsPossible(int newPosition){
        if(newPosition >= 0 && newPosition <= 10)
            return true;
        return false;
    }

    public int[] getPosition(){
        return position;
    }
}