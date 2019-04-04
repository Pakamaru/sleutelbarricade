package models;

import gui.Assets;
import gui.Display;
import models.levels.Level;
import models.levels.Level1;
import models.levels.Level2;
import models.levels.Level3;
import models.tiles.*;

import javax.sound.sampled.Clip;

public class Field{
    private Tile[][] tiles;
    private Display display;
    private Object level;
    private final int TOTALLEVELS = 3;
    public Field(Display display, int curLevel){
        this.level = getNextLevel(curLevel);
        this.tiles = ((Level) level).getLevel();
        this.display = display;
        display.showField(this, 0, 0);
    }

    private Object getRandomLevel(){
        Object lvl = new Object();
        int randomNumber = (int) (Math.random()*TOTALLEVELS)+1;
        System.out.println(randomNumber);
        if(randomNumber == 1)
            lvl = new Level1();
        if(randomNumber == 2)
            lvl = new Level2();
        return lvl;
    }

    private Object getNextLevel(int nextLevel){
        Object lvl = new Object();
        switch(nextLevel){
            case 1:
                lvl = new Level1();
                break;
            case 2:
                lvl = new Level2();
                break;
            case 3:
                lvl = new Level3();
        }
        return lvl;
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

    public int totalLevels(){
        return this.TOTALLEVELS;
    }
}
