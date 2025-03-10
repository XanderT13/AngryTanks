package AngryTanks.model;

public class Tank {
    private boolean isDead;
    private Coordinates coordinates;

    public Tank(Coordinates coordinates){
        this.coordinates = coordinates;
        isDead = false;
    }

    public boolean isDead() {
        return isDead;
    }

    public Coordinates getCoordinaten() {
        return coordinates;
    }
}
