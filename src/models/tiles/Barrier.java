package models.tiles;

import models.TileType;
import models.tiles.Tile;

public class Barrier extends Tile {
    private int number;
    public Barrier(int number){
        this.type = TileType.BARRIER;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
