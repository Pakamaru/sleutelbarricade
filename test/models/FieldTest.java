package models;

import gui.Display;
import models.levels.Level;
import models.levels.Level1;
import models.levels.Level2;
import models.levels.Level3;
import models.tiles.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FieldTest {
    Game game = new Game();
    Display display = new Display("Game", 1200, 850, game);
    Field field = new Field(display, 1);

    @Test
    public void hitWall() {
        boolean result = field.hitWall(new SolidWall(0, 0));

        Assert.assertEquals(false, result);
    }

    @Test
    public void hitBarrier_1() {
        boolean result = field.hitBarrier(new Barrier(0, 0, 100), 100);

        Assert.assertEquals(true, result);
    }

    @Test
    public void hitBarrier_2() {
        boolean result = field.hitBarrier(new Barrier(0, 0, 200), 100);

        Assert.assertEquals(false, result);
    }

    @Test
    public void hitKey() {
        boolean result = field.hitKey(new KeyTile(0, 0, new Key(100)), new Pocket());

        Assert.assertEquals(true, result);
    }

    @Test
    public void hitTile() {
        boolean result = field.hitTile(new Tile(0, 0));

        Assert.assertEquals(true, result);
    }

    @Test
    public void hitEnd() {
        boolean result = field.hitEnd(new EndTile(0, 0));

        Assert.assertEquals(true, result);
    }

    @Test
    public void getNextLevel(){
        int nextLevel = 2;
        Object lvl = new Object();
        Object level2 = new Level2();
        switch(nextLevel){
            case 1:
                lvl = new Level1();
                break;
            case 2:
                lvl = new Level2();
                break;
            case 3:
                lvl = new Level3();
        }boolean equal = true;

        for(int i = 0; i < ((Level2) lvl).getLevel().length; i++){
            for(int j = 0; j < ((Level2) lvl).getLevel().length; j++){
                if(((Level2) lvl).getLevel()[i][j].equals(((Level2) level2).getLevel()[i][j]))
                    equal = false;
            }
        }

        Assert.assertEquals(true, equal);
    }
    @Test
    public void getTiles() {
        Tile[][] result = field.getTiles();
        Field field2 = new Field(display, 1);
        boolean equal = true;

        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[i].length; j++){
                if(result[i][j].equals(field2.getTiles()[i][j]))
                    equal = false;
            }
        }

        Assert.assertEquals(true, equal);
    }
}