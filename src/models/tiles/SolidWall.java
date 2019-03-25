package models.tiles;

import models.TileType;
import models.tiles.Tile;

public class SolidWall extends Tile {
    public SolidWall(int x, int y){
        super(x, y);
        this.type = TileType.WALL;
    }
}
