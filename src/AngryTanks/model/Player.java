package AngryTanks.model;

public class Player {
    private Tank tank;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void playTurn(Wind wind) {
    }

    public Tank getTank() {
        return tank;
    }

    public String getName() {
        return name;
    }
}
