package models.tiles;

import models.TileType;

public class Tile {
    protected TileType type;

    public Tile(){
        this.type = TileType.NORMAL;
    }

    public TileType getType() {
        return type;
    }
}
