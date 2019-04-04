package models.tiles;

import models.TileType;

public class PlayerStart extends Tile{

    public PlayerStart(int x, int y){
        super(x, y);
        this.type = TileType.PLAYERSTART;
    }
}
