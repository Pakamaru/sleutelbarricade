package models;

import gui.Assets;
import gui.Display;
import gui.Graph;
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
        display = new Display("Game", Graph.getTileWidth()*10+12, Graph.getTileHeight()*10);
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

