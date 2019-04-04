package input;

import models.Direction;
import models.Game;
import models.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Lets certain keys do specific actions
 */
public class KeyManager implements KeyListener {
    private Player player;

    public KeyManager(Player player){
        this.player = player;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Initializes the keys
     * @param ke pressed key input
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();
        switch(key){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                player.move(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                player.move(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                player.move(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                player.move(Direction.RIGHT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
