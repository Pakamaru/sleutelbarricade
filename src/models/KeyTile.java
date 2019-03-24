package models;

public class KeyTile extends Tile{
    private Key key;

    public KeyTile(Key key){
        this.type = "key";
        this.key = key;
    }

    public Key getKey() {
        return key;
    }
}
