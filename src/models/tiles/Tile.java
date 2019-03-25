package models.tiles;

import models.TileType;

public class Tile {
    protected TileType type;
    protected int x;
    protected int y;

    public Tile(int x, int y){
        this.type = TileType.NORMAL;
        this.x = x;
        this.y = y;
    }

    public TileType getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
