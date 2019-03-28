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
        this.display = new Display("Game", 800, 800);
        this.field = new Field(display);
        this.player = new Player(display, field, this);
        this.keyManager = new KeyManager(player, this);
        this.display.getMyFrame().addKeyListener(keyManager);
    }

    public void levelEnd(){
        System.out.println("test");
        this.field = new Field(display);
        this.player = new Player(display, field, this);
        this.keyManager = new KeyManager(player, this);

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }
}

