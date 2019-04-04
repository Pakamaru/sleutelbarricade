package models;

import gui.Assets;
import gui.Display;
import input.KeyManager;

/**
 * Class used for the creation of multiple components in the game.
 */
public class Game{
    private Display display;
    private Player player;
    private KeyManager keyManager;
    private Field field;
    private int curLevel;

    /**
     * Initializes multiple things:
     * - The width and height of the display
     * - The current level that is being played
     * - The player
     * - The Key listeners
     */
    public Game() {
        this.curLevel = 1;
        Assets.init();
        this.display = new Display("Game", 1200, 850, this);
        this.field = new Field(display, curLevel);
        this.player = new Player(display, field, this, field.getPlayerStart()[0], field.getPlayerStart()[1]);
        this.keyManager = new KeyManager(player);
        this.display.getMyFrame().addKeyListener(keyManager);
    }

    /**
     * Method used to let the game know what to do when a level is completed
     */
    public void levelEnd(){
        this.curLevel++;
        if(this.curLevel > field.totalLevels()){
            display.showWinScreen();
            this.curLevel = 1;
        }
        this.display.getMyFrame().removeKeyListener(keyManager);
        this.field = new Field(display, this.curLevel);
        this.player = new Player(display, field, this, field.getPlayerStart()[0], field.getPlayerStart()[1]);
        this.keyManager = new KeyManager(player);
        this.display.getMyFrame().addKeyListener(keyManager);
    }

    /**
     * Method used when the player has pressed the reset button.
     */
    public void restartLevel(){
        this.display.getMyFrame().removeKeyListener(keyManager);
        this.field = new Field(display, this.curLevel);
        this.player = new Player(display, field, this, field.getPlayerStart()[0], field.getPlayerStart()[1]);
        this.keyManager = new KeyManager(player);
        this.display.getMyFrame().addKeyListener(keyManager);
    }

    /**
     * Getter for the keymanager
     * @return the used keymanager
     */
    public KeyManager getKeyManager(){
        return keyManager;
    }
}