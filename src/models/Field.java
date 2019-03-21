package models;

public class Field{
    private Tile[][] tiles = new Tile[10][10];
    public Field(){
        for(int i = 0; i<tiles.length; i++){
            for(int j = 0; j<tiles[i].length; j++){
                if(i == 3){
                    tiles[i][j] = new KeyTile();
                }else {
                    tiles[i][j] = new Tile();
                }
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
