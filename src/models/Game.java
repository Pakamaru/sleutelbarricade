package models;

import gui.Display;

import java.io.IOException;

public class Game{
    private Display display;
    private Player player;

    private boolean active = true;

    public Game() throws IOException {
        display = new Display("Game", 800, 800);
        player = new Player();
    }

    public boolean getActive(){
        return active;
    }

}
