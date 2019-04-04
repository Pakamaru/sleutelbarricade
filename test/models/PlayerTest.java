package models;

import gui.Display;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void can_move() {
        Game game = new Game();
        Player player = new Player(new Display("test", 1000, 1000, game), new Field(new Display("test", 1000, 1000, game), 1), game);

        player.move(Direction.DOWN);
        player.move(Direction.DOWN);
        player.move(Direction.DOWN);
        player.move(Direction.DOWN);
        player.move(Direction.DOWN);
        int[] pos = player.getPosition();
        int result = pos[1];
        Assert.assertEquals(1, result);
    }

    @Test
    public void can_get_Position() {
        Game game = new Game();
        Player player = new Player(new Display("test", 1000, 1000, game), new Field(new Display("test", 1000, 1000, game), 1), game);

        player.move(Direction.RIGHT);
        player.move(Direction.RIGHT);
        player.move(Direction.RIGHT);
        player.move(Direction.RIGHT);
        player.move(Direction.RIGHT);
        int[] pos = player.getPosition();
        int result = pos[0];
        Assert.assertEquals(5, result);
    }

    @Test
    public void can_get_Orientation_1() {
        Game game = new Game();
        Player player = new Player(new Display("test", 1000, 1000, game), new Field(new Display("test", 1000, 1000, game), 1), game);

        player.move(Direction.RIGHT);
        Direction result = player.getOrientation();
        Assert.assertEquals(Direction.RIGHT, result);
    }

    @Test
    public void can_get_Orientation_2() {
        Game game = new Game();
        Player player = new Player(new Display("test", 1000, 1000, game), new Field(new Display("test", 1000, 1000, game), 1), game);

        player.move(Direction.UP);
        Direction result = player.getOrientation();
        Assert.assertEquals(Direction.UP, result);
    }
}