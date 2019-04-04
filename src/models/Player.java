package models;

import gui.Display;

/**
 * Creates the player
 */
public class Player{
    private int x;
    private int y;
    private int[] position;
    private Direction orientation;
    private boolean hitEnd;
    private Display ui;
    private Field field;
    private Pocket pocket;
    private Game game;

    /**
     * Creates a new player
     * @param ui lets the display know that the field should be drawn again, because the player has moved
     * @param field gives a value to graph that lets it draw the field
     * @param game makes it possible for the player to use certain actions
     */
    public Player(Display ui, Field field, Game game, int x, int y){
        this.x = field.getPlayerStart()[0];
        this.y = field.getPlayerStart()[1];
        this.position = new int[]{x, y};
        this.orientation = Direction.DOWN;
        this.hitEnd = false;
        this.ui = ui;
        this.field = field;
        this.pocket = new Pocket();
        this.game = game;
    }

    /**
     * initializes the keys to their directions
     * @param direction the direction the player moves when a key is pressed
     **/
    public void move(Direction direction){
        if(direction.equals(Direction.NONE))
            return;
        switch(direction){
            case UP: if(moveIsPossible(new int[]{this.position[0], this.position[1]-1})){ this.y--; }
                this.orientation = Direction.UP;
                break;
            case DOWN: if(moveIsPossible(new int[]{this.position[0], this.position[1]+1})){ this.y++; }
                this.orientation = Direction.DOWN;
                break;
            case LEFT: if(moveIsPossible(new int[]{this.position[0]-1, this.position[1]})){ this.x--; }
                this.orientation = Direction.LEFT;
                break;
            case RIGHT: if(moveIsPossible(new int[]{this.position[0]+1, this.position[1]})){ this.x++; }
                this.orientation = Direction.RIGHT;
                break;
        }
        this.position[0] = x;
        this.position[1] = y;
        ui.showField(field, position[0], position[1]);
        if(this.hitEnd)
            game.levelEnd();

        //TODO: adding orientation to this when we finally get the gui to work properly
    }

    /**
     * Boolean used to declare if the move is possible
     * @param newPosition the position of the player
     * @return if the move is possible, the value will be true and the player will be able to move.
     * if the move isn't possible, the value will be false and the player will be able to move
     */
    private boolean moveIsPossible(int[] newPosition){
        if(newPosition[0] >= 0 && newPosition[0] <= 9 && newPosition[1] >= 0 && newPosition[1] <= 9){
            Object tile = field.getTiles()[newPosition[0]][newPosition[1]];
            System.out.println(field.getTiles()[newPosition[0]][newPosition[1]].getType());
            switch(field.getTiles()[newPosition[0]][newPosition[1]].getType()){
                case NORMAL:
                    return field.hitTile(tile);
                case KEY:
                    return field.hitKey(tile, pocket);
                case END:
                    this.hitEnd = true;
                    return field.hitEnd(tile);
                case BARRIER:
                    return field.hitBarrier(tile, this.pocket.getKey().getNumber());
                case WALL:
                    return field.hitWall(tile);
            }
        }
        return false;
    }

    /**
     * Getter for the current position of the player
     * @return the current position of the player
     */
    public int[] getPosition(){
        return position;
    }

    /**
     * Getter for the direction the player will be moving
     * @return the direction the player will be moving
     */
    public Direction getOrientation() {
        return orientation;
    }
}