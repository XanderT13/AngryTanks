package AngryTanks.model;

import java.util.Random;

import static AngryTanks.model.WindDirection.*;

public class Wind {
    private double power;
    private WindDirection direction;
    boolean windOff = false;

    public Wind() {
        generateWind();
    }

    public void generateWind() {
        if (windOff) {
            power = 0;
            direction = WindDirection.NONE;
            return;
        }
        Random rand = new Random();
        direction = rand.nextBoolean() ? LEFT : RIGHT;
        power = rand.nextDouble(6);
    }

    public double getPower() {
        return power;
    }

    public WindDirection getDirection() {
        return direction;
    }

    public void setWindOff(int wind) {
        if (wind == 0) {
            power = 0;
            direction = WindDirection.NONE;
            windOff = true;
        } else if (wind == 1) {
            windOff = false;
        }
    }

    @Override
    public String toString() {
        return String.format("WIND: %.1f: %s", power, direction);
    }
}
