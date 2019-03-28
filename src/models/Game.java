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

    public Game() {
        Assets.init();
        field = new Field();
        display = new Display("Game", 800, 800, field);
        player = new Player(display, field);
        keyManager = new KeyManager(player);
        display.getMyFrame().addKeyListener(keyManager);
        field.setDisplay(display);
    }

    public boolean getActive(){
        return player.playerHitEnd();
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }
}

