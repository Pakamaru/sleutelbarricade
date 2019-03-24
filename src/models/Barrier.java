package models;

public class Barrier extends Tile{
    private int number;
    public Barrier(int number){
        this.type = "barrier";
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
