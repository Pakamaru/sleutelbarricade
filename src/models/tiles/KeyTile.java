package models.tiles;

import models.Key;
import models.TileType;
import models.tiles.Tile;

public class KeyTile extends Tile {
    private Key key;

    public KeyTile(int x, int y, Key key){
        super(x, y);
        this.type = TileType.KEY;
        this.key = key;
    }

    public Key getKey() {
        return key;
    }
}
