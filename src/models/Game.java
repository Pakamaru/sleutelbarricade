package models;

import gui.Display;
import input.KeyManager;

import java.io.IOException;

public class Game{
    private Display display;
    private Player player;
    private KeyManager keyManager;

    private boolean active = true;

    public Game() throws IOException{
        player = new Player();
        keyManager = new KeyManager(player);
        display = new Display("Game", 800, 800);
        display.getMyFrame().addKeyListener(keyManager);
    }

    public boolean getActive(){
        return active;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
}

