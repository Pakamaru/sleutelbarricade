package models;

public class Field{
    private Tile[][] tiles = new Tile[10][10];
    public Field(){
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

    public Tile[][] getTiles() {
        return tiles;
    }
}
