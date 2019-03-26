package models;

import gui.Assets;
import models.levels.Level1;
import models.tiles.*;

public class Field{
    private Tile[][] tiles;
    public Field(){
        Level1 lv1 = new Level1();
        this.tiles = lv1.getLevel();
    }

    public boolean hitWall(Object tile){
        SolidWall wallTile = (SolidWall) tile;
        return false;
    }
    public boolean hitBarrier(Object tile, int number){
        Barrier barrierTile = (Barrier) tile;
        if(number == barrierTile.getNumber()){
            this.tiles[barrierTile.getX()][barrierTile.getY()] = new Tile(barrierTile.getX(),barrierTile.getY());
            try {
                Assets.lock.stop();
                Assets.lock.setFramePosition(0);
                Assets.lock.start();
                Assets.lock.setFramePosition(0);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("Opened lock!!");
            return true;
        }
        try {
            Assets.wall.stop();
            Assets.wall.setFramePosition(0);
            Assets.wall.start();
            Assets.wall.setFramePosition(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("INSERT BUMP SOUND");
        return false;
    }
    public boolean hitKey(Object tile, Pocket pocket){
        KeyTile keyTile = (KeyTile) tile;
        pocket.setKey(keyTile.getKey());
        this.tiles[keyTile.getX()][keyTile.getY()] = new Tile(keyTile.getX(),keyTile.getY());
        System.out.println("Picked up key "+pocket.getKey().getNumber());
        return true;
    }
    public boolean hitTile(Object tile){
        Tile normalTile = (Tile) tile;
        try {
            Assets.walk.stop();
            Assets.walk.setFramePosition(0);
            Assets.walk.start();
            Assets.walk.setFramePosition(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("INSERT WALK SOUND");
        return true;
    }
    public boolean hitEnd(Object tile){
        EndTile endTile = (EndTile) tile;
        try {
            Assets.victory.stop();
            Assets.victory.setFramePosition(0);
            Assets.victory.start();
            Assets.victory.setFramePosition(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("GRATS YOU WON BITCH");
        return true;
    }

        public Tile[][] getTiles() {
        return tiles;
    }
}
