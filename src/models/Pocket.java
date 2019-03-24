package models;

public class Pocket{
    private Key key;

    public Pocket(){
        this.key = new Key(0);
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }
}
