package AngryTanks.model;

import java.util.ArrayList;
import java.util.List;

public class Tank {
    private int lives;
    private Coordinates gunCoordinates;
    private List<Coordinates> tankCoordinates;
    private boolean facingRight;

    public Tank(Coordinates coordinates, boolean facingRight) {
        this.facingRight = facingRight;
        gunCoordinates = coordinates;
        tankCoordinates = new ArrayList<>();
        tankCoordinates.add(coordinates);
        lives = 3;
    }

    public void drawTank() {
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
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Coordinates getCoordinaten() {
        return gunCoordinates;
    }

    public List<Coordinates> getTankCoordinates() {
        return tankCoordinates;
    }

    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }

    public void setGunCoordinates(Coordinates gunCoordinates) {
        this.gunCoordinates = gunCoordinates;
    }

    public boolean isFacingRight() {
        return facingRight;
    }
}
