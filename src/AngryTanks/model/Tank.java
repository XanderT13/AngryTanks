package AngryTanks.model;

import java.util.ArrayList;
import java.util.List;

public class Tank {
    private boolean isDead;
    private Coordinates gunCoordinates;
    private List<Coordinates> tankCoordinates;

    public Tank(Coordinates coordinates){
        gunCoordinates = coordinates;
        tankCoordinates = new ArrayList<Coordinates>();
        tankCoordinates.add(coordinates);
        tankCoordinates.add(new Coordinates(coordinates.getX() - 1,coordinates.getY() - 1));
        tankCoordinates.add(new Coordinates(coordinates.getX(),coordinates.getY() - 1));
        tankCoordinates.add(new Coordinates(coordinates.getX() - 1,coordinates.getY()));
        isDead = false;
    }

    public boolean isDead() {
        return isDead;
    }

    public Coordinates getCoordinaten() {
        return gunCoordinates;
    }
}
