package models;

import models.tiles.Barrier;
import models.tiles.KeyTile;
import models.tiles.Tile;

public class Field{
    private Tile[][] tiles;
    public Field(){
        Level1 lv1 = new Level1();
        this.tiles = lv1.getLevel();
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
