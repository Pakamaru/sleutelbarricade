package models;

import gui.Assets;
import gui.Display;
import input.KeyManager;

public class Game{
    private Display display;
    private Player player;
    private KeyManager keyManager;

    private boolean active = true;

    public Game() {
        Assets.init();
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

