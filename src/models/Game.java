package models;

import gui.Assets;
import gui.Display;
import gui.Graph;
import input.KeyManager;

public class Game{
    private Display display;
    private Player player;
    private KeyManager keyManager;
    private Field field;

    private boolean active;

    public Game() {
        Assets.init();
        field = new Field();
        display = new Display("Game", 800, 800, field);
        player = new Player(display, field);
        keyManager = new KeyManager(player);
        display.getMyFrame().addKeyListener(keyManager);
        field.setDisplay(display);
        this.active = true;
    }

    public boolean getActive(){
        return this.active;
    }

    public boolean levelActive(){
        return player.playerHitEnd();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }
}

