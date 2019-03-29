package models.levels;

import models.Key;
import models.tiles.*;

public class Level{
    protected Tile[][] tiles = new Tile[10][10];
    protected int[][][] tileCreator;
    protected int[][][] fixedTileCreator;
    protected final int NORMAL = 0;
    protected final int KEY = 1;
    protected final int BARRIER = 2;
    protected final int WALL = 3;
    protected final int END = 4;

    public Level(){
        tileCreator = new int[][][]{
                { {},      {},     {},      {},     {},     {},     {},     {},     {},     {} },
                { {},      {},     {},      {},     {},     {},     {},     {},     {},     {} },
                { {},      {},     {},      {},     {},     {},     {},     {},     {},     {} },
                { {},      {},     {},      {},     {},     {},     {},     {},     {},     {} },
                { {},      {},     {},      {},     {},     {},     {},     {},     {},     {} },
                { {},      {},     {},      {},     {},     {},     {},     {},     {},     {} },
                { {},      {},     {},      {},     {},     {},     {},     {},     {},     {} },
                { {},      {},     {},      {},     {},     {},     {},     {},     {},     {} },
                { {},      {},     {},      {},     {},     {},     {},     {},     {},     {} },
                { {},      {},     {},      {},     {},     {},     {},     {},     {},     {} }
        };
        fixedTileCreator = tileCreator;
    }

    public void fixLayout(){
        for(int i = 0; i<tiles.length; i++){
            for(int j = 0; j<tiles[i].length; j++) {
                this.fixedTileCreator[j][i] = this.tileCreator[i][j];
            }
        }
    }

    public void createMap(){
        for(int i = 0; i<tiles.length; i++){
            for(int j = 0; j<tiles[i].length; j++) {
                if(fixedTileCreator[i][j].length == 0)
                    fixedTileCreator[i][j] = new int[]{NORMAL};
                switch(fixedTileCreator[i][j][0]){
                    case NORMAL:
                        this.tiles[i][j] = new Tile(i, j);
                        break;
                    case KEY:
                        this.tiles[i][j] = new KeyTile(i, j, new Key(fixedTileCreator[i][j][1]));
                        break;
                    case BARRIER:
                        this.tiles[i][j] = new Barrier(i, j, fixedTileCreator[i][j][1]);
                        break;
                    case WALL:
                        this.tiles[i][j] = new SolidWall(i, j);
                        break;
                    case END:
                        this.tiles[i][j] = new EndTile(i, j);
                        break;
                }
            }
        }
    }

    public Tile[][] getLevel() {
        return tiles;
    }
}
