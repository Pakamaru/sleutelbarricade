package models;

import gui.Assets;
import gui.Display;
import input.KeyManager;

public class Game{
    private Display display;
    private Player player;
    private KeyManager keyManager;
    private Field field;
    private int curLevel;

    public Game() {
        this.curLevel = 1;
        Assets.init();
        this.display = new Display("Game", 1200, 850, this);
        this.field = new Field(display, curLevel);
        this.player = new Player(display, field, this);
        this.keyManager = new KeyManager(player, this);
        this.display.getMyFrame().addKeyListener(keyManager);
    }

    public void levelEnd(){
        if (curLevel<3){
            this.curLevel++;
        }
        else {
            curLevel=1;
        }
        this.display.getMyFrame().removeKeyListener(keyManager);
        this.field = new Field(display, this.curLevel);
        this.player = new Player(display, field, this);
        this.keyManager = new KeyManager(player, this);
        this.display.getMyFrame().addKeyListener(keyManager);
    }

    public void restartLevel(){
        this.display.getMyFrame().removeKeyListener(keyManager);
        this.field = new Field(display, this.curLevel);
        this.player = new Player(display, field, this);
        this.keyManager = new KeyManager(player, this);
        this.display.getMyFrame().addKeyListener(keyManager);
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }
}

