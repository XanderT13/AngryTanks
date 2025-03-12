package AngryTanks.model;

import java.util.ArrayList;
import java.util.List;

public class Tank {
    private boolean isDead;
    private Coordinates gunCoordinates;
    private List<Coordinates> tankCoordinates;

    public Tank(Coordinates coordinates, boolean facingRight) {
        gunCoordinates = coordinates;
        tankCoordinates = new ArrayList<Coordinates>();
        tankCoordinates.add(coordinates);
        int gunX = gunCoordinates.getX();
        int gunY = gunCoordinates.getY();
        if (facingRight) {
            tankCoordinates.add(new Coordinates(gunX, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX - 1, gunY + 1));
            tankCoordinates.add(new Coordinates(gunX - 1, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX - 1, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX - 2, gunY + 2));
            tankCoordinates.add(new Coordinates(gunX - 2, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX - 2, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX - 3, gunY + 1));
            tankCoordinates.add(new Coordinates(gunX - 3, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX - 3, gunY + 2));
            tankCoordinates.add(new Coordinates(gunX - 3, gunY + 3));
            tankCoordinates.add(new Coordinates(gunX - 3, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX - 4, gunY + 1));
            tankCoordinates.add(new Coordinates(gunX - 4, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX - 4, gunY + 2));
            tankCoordinates.add(new Coordinates(gunX - 4, gunY + 3));
            tankCoordinates.add(new Coordinates(gunX - 4, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX - 5, gunY + 3));
            tankCoordinates.add(new Coordinates(gunX - 5, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX - 5, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX - 6, gunY + 3));
            tankCoordinates.add(new Coordinates(gunX - 6, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX - 6, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX - 7, gunY + 4));
        } else {
            tankCoordinates.add(new Coordinates(gunX, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX + 1, gunY + 1));
            tankCoordinates.add(new Coordinates(gunX + 1, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX + 1, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX + 2, gunY + 2));
            tankCoordinates.add(new Coordinates(gunX + 2, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX + 2, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX + 3, gunY + 1));
            tankCoordinates.add(new Coordinates(gunX + 3, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX + 3, gunY + 2));
            tankCoordinates.add(new Coordinates(gunX + 3, gunY + 3));
            tankCoordinates.add(new Coordinates(gunX + 3, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX + 4, gunY + 1));
            tankCoordinates.add(new Coordinates(gunX + 4, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX + 4, gunY + 2));
            tankCoordinates.add(new Coordinates(gunX + 4, gunY + 3));
            tankCoordinates.add(new Coordinates(gunX + 4, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX + 5, gunY + 3));
            tankCoordinates.add(new Coordinates(gunX + 5, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX + 5, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX + 6, gunY + 3));
            tankCoordinates.add(new Coordinates(gunX + 6, gunY + 4));
            tankCoordinates.add(new Coordinates(gunX + 6, gunY + 5));
            tankCoordinates.add(new Coordinates(gunX + 7, gunY + 4));
        }
        isDead = false;
    }

    public boolean isDead() {
        return isDead;
    }

    public Coordinates getCoordinaten() {
        return gunCoordinates;
    }

    public List<Coordinates> getTankCoordinates() {
        return tankCoordinates;
    }
}
