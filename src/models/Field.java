package models;

import gui.Assets;
import gui.Display;
import models.levels.Level;
import models.levels.Level1;
import models.levels.Level2;
import models.levels.Level3;
import models.tiles.*;

import javax.sound.sampled.Clip;

/**
 * Chooses what level is played, also creates certain actions the player can do.
 * For example, it makes it possible for the player to pick up the keys
 */

public class Field{
    private Tile[][] tiles;
    private Display display;
    private Object level;
    private final int TOTALLEVELS = 3;

    public Field(Display display, int curLevel){
        this.level = getNextLevel(curLevel);
        this.tiles = ((Level) level).getLevel();
        this.display = display;
        display.showField(this, this.getPlayerStart()[0], this.getPlayerStart()[1]);
    }

    /**
     * Randomly chooses what level will be played
     * @return the level that will be generated
     */
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

    /**
     * When a level is completed, it will load the next level
     * @param nextLevel variable used to determine what the next level will be
     * @return the value that will let the game load the right level
     */
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

    /**
     * Creates the action that happens when a player hits a wall
     * @param tile is the specific tiletype that is being hit by the player
     * @return if the player hits a wall it will return false so the player cant move through the wall
     */
    public boolean hitWall(Object tile){
        SolidWall wallTile = (SolidWall) tile;
        return false;
    }

    /**
     * Creates the action that happens when a player hits a barrier
     * @param tile is the specific tiletype that is being hit by the player
     * @param number the value of the barrier
     * @return if the value of the barrier matches the value of the key then the barrier will disappear.It also makes it walkable for the player.
     * If it doesnt match the value of the key, a sound will be played and the player is not able to walk through the barrier
     *
     */
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

    /**
     * Creates the action that happens when a player walks on a keytile
     * @param tile us the specific tiletype that is being hit by the player
     * @param pocket the value of the key that is in the pocket of the player
     * @return replaces the value of the key that is currently in the player's pocket, and makes it walkable for the player
     */
    public boolean hitKey(Object tile, Pocket pocket){
        KeyTile keyTile = (KeyTile) tile;
        pocket.setKey(keyTile.getKey());
        this.tiles[keyTile.getX()][keyTile.getY()] = new Tile(keyTile.getX(),keyTile.getY());
        display.showTextBox("Picked up key " + pocket.getKey().getNumber() + "!");
        return true;
    }

    /**
     * Creates the action that happens when a player walks
     * @param tile is the specific tiletype that the player is going to move to
     * @return a sound that is played and makes it walkable for the player
     */
    public boolean hitTile(Object tile){
        Tile normalTile = (Tile) tile;
        playClip(Assets.walk);
        return true;
    }

    /**
     * Creates the action that happens when a player walks on a endtile
     * @param tile is the specific tiletype that the player is going to move to
     * @return a sound that is played and makes it walkable for the player
     */
    public boolean hitEnd(Object tile){
        EndTile endTile = (EndTile) tile;
        playClip(Assets.victory);
        display.showTextBox("Congratulations! You won!");
        return true;
    }

    /**
     * Used to initialize the soundeffects
     * @param clip sound effect that is used in the game
     */
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

    /**
     * A getter for the tiles
     * @return the tiles
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * An int that is used to declare the amount of levels that are in the game
     * @return TOTALLEVELS the amount of levels there are in the game
     */
    public int totalLevels(){
        return this.TOTALLEVELS;
    }

    public int[] getPlayerStart(){
        int[] pos = {0,0};
        for(int i = 0; i < tiles.length; i++){
            for(int j = 0; j < tiles[i].length; j++){
                if(tiles[i][j].getType() == TileType.PLAYERSTART){
                    pos = new int[]{i, j};
                }
            }
        }
        return pos;
    }
}
