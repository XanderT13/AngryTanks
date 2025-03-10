package AngryTanks.model;

import java.util.LinkedList;
import java.util.List;

public class Trajectory {
    private List<Coordinates> trajectory;

    public Trajectory(Shot shot, Wind wind, Tank tank) {
        double y;
        trajectory = new LinkedList<Coordinates>();
        double windPower = switch (wind.getDirection()) {
            case LEFT -> -wind.getPower();
            case RIGHT -> wind.getPower();
        };
        if (shot.getAngle() < Math.PI / 2) {
            for (int x = 0; x < 60 - tank.getCoordinaten().getX(); x++) {
                double deel1, deel2, deel3;
                deel1 = -(9.81 / 2) / Math.pow(shot.getVelocity() * Math.cos(shot.getAngle()) - windPower, 2);
                deel2 = Math.sin(shot.getAngle()) / (Math.cos(shot.getAngle()) - (windPower / shot.getVelocity()));
                deel3 = 59 - tank.getCoordinaten().getY();
                y = deel1 * Math.pow(x, 2) + deel2 * x + deel3;
                trajectory.add(new Coordinates(x + tank.getCoordinaten().getX(), (int) Math.round(y)));
            }
        } else
            for (int x = 0; x > -tank.getCoordinaten().getX() - 1; x--) {
                double deel1, deel2, deel3;
                deel1 = -(9.81 / 2) / Math.pow(shot.getVelocity() * Math.cos(shot.getAngle()) - windPower, 2);
                deel2 = Math.sin(shot.getAngle()) / (Math.cos(shot.getAngle()) - (windPower / shot.getVelocity()));
                deel3 = 59 - tank.getCoordinaten().getY();
                y = deel1 * Math.pow(x, 2) + deel2 * x + deel3;
                trajectory.add(new Coordinates((tank.getCoordinaten().getX()) + x, (int) Math.round(y)));
            }
    }

    public List<Coordinates> getTrajectory() {
        return trajectory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trajectory: ");
        for (Coordinates coord : trajectory) {
            sb.append("Y: " + coord.getY());
        }
        return sb.toString();
    }
}
