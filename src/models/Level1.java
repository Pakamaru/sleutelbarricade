package models;

import models.tiles.*;

public class Level1{
    private Tile[][] tiles = new Tile[10][10];
    public Level1(){
        for(int i = 0; i<tiles.length; i++){
            for(int j = 0; j<tiles[i].length; j++) {
                //Key 300
                if (i == 0 && j == 8) {
                    tiles[i][j] = new KeyTile(new Key(300));
                } else if (i == 1 && j == 6 || i == 5 && j == 2 || i == 5 && j == 3 || i == 5 && j == 4 || i == 6 && j == 7 || i == 6 && j == 8) {
                    tiles[i][j] = new Barrier(300);
                }
                //Key 200
                else if(i == 7 && j == 9 ){
                    tiles[i][j] = new KeyTile(new Key(200));
                } else if (i == 4 && j == 1 || i == 4 && j == 2 || i == 5 && j == 1 || i == 7 && j == 6){
                    tiles[i][j] = new Barrier(200);
                }
                //Key 400
                else if(i == 2 && j == 9){
                    tiles[i][j] = new KeyTile(new Key(400));
                } else if(i == 7 && j == 4 || i == 7 && j == 5){
                    tiles[i][j] = new Barrier(400);
                }
                //key 500
                else if (i == 3 && j == 4){
                    tiles[i][j] = new KeyTile(new Key(500));
                } else if(i == 4 && j == 3 || i == 4 && j == 4 || i == 5 & j == 9){
                    tiles[i][j] = new Barrier(500);
                }
                //Key 600
                else if (i == 9 && j == 3){
                    tiles[i][j] = new KeyTile(new Key(600));
                } else if(i == 8 && j == 6){
                    tiles[i][j] = new Barrier(600);
                }
                //Key 700
                else if(i == 8 && j == 4){
                    tiles[i][j] = new KeyTile(new Key(700));
                } else if(i == 7 && j == 2 || i ==7 && j == 3){
                    tiles[i][j] = new Barrier(700);
                }
                //Solid Walls
                else if(i == 1 && j == 0 || i == 1 && j == 1 || i == 1 && j == 2 || i == 1 && j == 3 || i == 1 && j == 4
                        || i == 1 && j == 5 || i == 1 && j == 7 || i == 1 && j == 8 || i == 1 && j == 9 ||

                        i == 2 && j == 5 || i == 2 && j == 7 || i == 2 && j == 8 ||

                        i == 3 && j == 1 || i == 3 && j == 2 || i == 3 && j == 3 || i == 3 && j == 5 ||
                        i == 3 && j == 7 || i == 3 && j == 8 ||

                        i == 4 && j == 7 || i == 4 && j == 8 ||

                        i == 5 && j == 7 || i == 5 && j == 8 ||

                        i == 6 && j == 0 || i == 6 && j == 1 || i == 6 && j == 2 || i == 6 && j == 3 ||
                        i == 6 && j == 4 || i == 6 && j == 5 ||

                        i == 8 && j == 1 || i == 8 && j == 2 || i == 8 && j == 3 || i == 8 && j == 5 ||
                        i == 8 && j == 7 || i == 8 && j == 8 || i == 8 && j == 9 ||

                        i == 9 && j == 4 ||i == 9 && j == 5 ){
                    tiles[i][j] = new SolidWall();
                }
                //End Tile
                else if(i == 9 && j == 9){
                    tiles[i][j] = new EndTile();
                }


                else {
                    tiles[i][j] = new Tile();
                }
            }
        }
    }

    public Tile[][] getLevel() {
        return tiles;
    }
}
