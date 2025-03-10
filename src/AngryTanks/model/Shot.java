package AngryTanks.model;

public class Shot {
    private double angle;
    private double velocity;

    public Shot(double angle, double velocity) {
        this.angle = angle;
        this.velocity = velocity;
    }

    public double getAngle() {
        return angle;
    }

    public double getVelocity() {
        return velocity;
    }
}
