package AngryTanks.model;

import java.util.Random;

import static AngryTanks.model.WindDirection.*;

public class Wind {
    private double power;
    private WindDirection direction;

    public Wind (){
       generateWind();
    }

    public void generateWind() {
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

    @Override
    public String toString() {
        return String.format("WIND: %.1f: %s", power, direction);
    }
}
