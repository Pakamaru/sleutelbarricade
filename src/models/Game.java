package models;

import gui.Display;

import java.io.IOException;

public class Game{
    private Display display;
    private Player player;
    private Field field;

    private boolean active = true;

    public Game() throws IOException {
        display = new Display();
        player = new Player();
        field = new Field();
        display.showField(field);
    }

    public boolean getActive(){
        return active;
    }

}
