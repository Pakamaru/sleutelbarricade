package models.tiles;

import models.TileType;
import models.tiles.Tile;

public class EndTile extends Tile {
    public EndTile(int x, int y){
        super(x, y);
        this.type = TileType.END;
    }
}
