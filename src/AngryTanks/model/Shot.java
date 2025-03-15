package AngryTanks.model;

public class Shot {
    private double angle;
    private double velocity;

    public Shot(double angle, double velocity) {
        this.angle = angle * Math.PI / 180;
        this.velocity = velocity;
    }

    public double getAngle() {
        return angle;
    }

    public double getVelocity() {
        return velocity;
    }

    @Override
    public String toString() {
        return "Shot{" +
                "angle=" + Math.round(angle * 180/ Math.PI) +
                ", velocity=" + Math.round(velocity) +
                '}';
    }
}
