package models.tiles;

import models.TileType;
import models.tiles.Tile;

public class SolidWall extends Tile {
    public SolidWall(){
        this.type = TileType.WALL;
    }
}
