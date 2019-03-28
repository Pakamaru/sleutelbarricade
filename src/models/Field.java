package models;

import gui.Assets;
import gui.Display;
import models.levels.Level1;
import models.tiles.*;

import javax.sound.sampled.Clip;

public class Field{
    private Tile[][] tiles;
    private Display display;
    public Field(Display display){
        Level1 lv1 = new Level1();
        this.tiles = lv1.getLevel();
        this.display = display;
        display.showField(this, 0, 0);
    }

    public boolean hitWall(Object tile){
        SolidWall wallTile = (SolidWall) tile;
        return false;
    }
    public boolean hitBarrier(Object tile, int number){
        Barrier barrierTile = (Barrier) tile;
        if(number == barrierTile.getNumber()){
            this.tiles[barrierTile.getX()][barrierTile.getY()] = new Tile(barrierTile.getX(),barrierTile.getY());
            display.showTextBox("Opened door " + barrierTile.getNumber() + "!");
            playClip(Assets.lock);
            System.out.println("Opened lock!!");
            return true;
        }
        playClip(Assets.wall);
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
        playClip(Assets.walk);
        return true;
    }
    public boolean hitEnd(Object tile){
        EndTile endTile = (EndTile) tile;
        playClip(Assets.victory);
        display.showTextBox("Congratulations! You won!");
        return true;
    }

    private void playClip(Clip clip){
        try {
            clip.stop();
            clip.setFramePosition(0);
            clip.start();
            clip.setFramePosition(0);
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
