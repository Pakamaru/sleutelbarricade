package models;

import gui.Assets;
import gui.Display;
import input.KeyManager;

public class Game{
    private Display display;
    private Player player;
    private KeyManager keyManager;
    private Field field;

    public Game() {
        Assets.init();
        this.display = new Display("Game", 800, 800, this);
        this.field = new Field(display);
        this.player = new Player(display, field, this);
        this.keyManager = new KeyManager(player, this);
        this.display.getMyFrame().addKeyListener(keyManager);
    }

    public void levelEnd(){
        this.display.getMyFrame().removeKeyListener(keyManager);
        this.field = new Field(display);
        this.player = new Player(display, field, this);
        this.keyManager = new KeyManager(player, this);
        this.display.getMyFrame().addKeyListener(keyManager);
    }

    public void restartLevel(){

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }
}

