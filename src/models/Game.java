package models;

import gui.Assets;
import gui.Display;
import input.KeyManager;

public class Game{
    private Display display;
    private Player player;
    private KeyManager keyManager;
    private Field field;

    private boolean active = true;

    public Game() {
        Assets.init();
        field = new Field();
        display = new Display("Game", 800, 800, field);
        player = new Player(display, field);
        keyManager = new KeyManager(player);
        display.getMyFrame().addKeyListener(keyManager);
    }

    public boolean getActive(){
        return active;
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }
}

