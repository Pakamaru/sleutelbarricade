package models;

/**
 * Initializes the value of the keys
 */
public class Key{
    private int number;

    /**
     * Makes it possible to easily create a key
     * @param number value of the key
     */
    public Key(int number){
        this.number = number;
    }

    /**
     * Getter for the value of the key
     * @return number value of the key
     */
    public int getNumber() {
        return number;
    }
}
