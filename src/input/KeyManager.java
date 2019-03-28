package input;

import models.Game;
import models.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
    private boolean up, down, left, right;
    private boolean[] keys;
    private Player player;
    private Game game;

    public KeyManager(Player player, Game game){
        keys = new boolean[5];
        this.player = player;
        this.game = game;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        up = false;
        down = false;
        left = false;
        right = false;
        if (key == KeyEvent.VK_UP) {
            up = true;
        } else if (key == KeyEvent.VK_DOWN) {
            down = true;
        } else if (key == KeyEvent.VK_LEFT) {
            left = true;
        } else if (key == KeyEvent.VK_RIGHT) {
            right = true;
        } else if (key == KeyEvent.VK_R) {
            game.levelEnd();
            return;
        }
        player.move((up)? "up": (down)? "down": (left)? "left": (right)? "right": "none");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
