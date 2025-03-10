package AngryTanks.model;

import java.util.Scanner;

public class Player {
    private Tank tank;
    private String name;

    public Player(String name, Tank tank) {
        this.name = name;
        this.tank = tank;
    }

    public void playTurn(Wind wind, double angle, double velocity) {
        new Trajectory(new Shot(angle, velocity), wind, tank);
    }

    public Tank getTank() {
        return tank;
    }

    public String getName() {
        return name;
    }
}
