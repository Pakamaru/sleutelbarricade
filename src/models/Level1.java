package models;

import models.tiles.Barrier;
import models.tiles.KeyTile;
import models.tiles.Tile;

public class Level1{
    private Tile[][] tiles = new Tile[10][10];
    public Level1(){
        for(int i = 0; i<tiles.length; i++){
            for(int j = 0; j<tiles[i].length; j++){
                if(i == 3 && j == 2){
                    tiles[i][j] = new KeyTile(new Key(300));
                }else if(i == 3 && j == 3) {
                    tiles[i][j] = new Barrier(300);
                }else {
                    tiles[i][j] = new Tile();
                }
            }
        }
    }

    public Tile[][] getLevel() {
        return tiles;
    }
}
