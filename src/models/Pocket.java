package models;

/**
 * Class that creates the pocket of the player where the value of the current key will be in
 */
public class Pocket{
    private Key key;

    /**
     * Creates the pocket
     */
    public Pocket(){
        this.key = new Key(0);
    }

    /**
     * Getter for the key
     * @return the value of the key
     */
    public Key getKey() {
        return key;
    }

    /**
     *Constructor for the key
     * @param key has the value of the key
     */
    public void setKey(Key key) {
        this.key = key;
    }
}
