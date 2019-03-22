package input;

import models.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class KeyManager implements KeyListener {
    private boolean up, down, left, right;
    private boolean[] keys;
    private Player player;

    public KeyManager(Player player){
        keys = new boolean[5];
        this.player = player;
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
        }
        player.move((up)? "up": (down)? "down": (left)? "left": (right)? "right": "none");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
