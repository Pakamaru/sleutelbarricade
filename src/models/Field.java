package models;

import gui.Assets;
import gui.Display;
import models.levels.Level1;
import models.tiles.*;

public class Field{
    private Tile[][] tiles;
    private Display display;
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
            display.showTextBox("Openen door " + barrierTile.getNumber() + "!");
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
        return false;
    }
    public boolean hitKey(Object tile, Pocket pocket){
        KeyTile keyTile = (KeyTile) tile;
        pocket.setKey(keyTile.getKey());
        this.tiles[keyTile.getX()][keyTile.getY()] = new Tile(keyTile.getX(),keyTile.getY());
        display.showTextBox("Picked up key " + pocket.getKey().getNumber() + "!");
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
        display.showTextBox("Congratulations! You won!");
        return true;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void setDisplay(Display display){
        this.display = display;
    }
}
