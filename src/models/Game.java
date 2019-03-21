package models;

import gui.Assets;
import gui.Display;
import input.KeyManager;

import java.io.IOException;

public class Game{
    private Display display;
    private Player player;
    private KeyManager keyManager;

    private boolean active = true;

    public Game() {
        Assets.init();
        keyManager = new KeyManager();
        display = new Display("Game", 800, 800);
        display.getMyFrame().addKeyListener(keyManager);
        player = new Player();
    }

    public boolean getActive(){
        return active;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
}

