package AngryTanks.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Trajectory {
    private List<Coordinates> trajectory;
    private ImpactType impactType;
    private List<Coordinates> impactRadius;

    public Trajectory(Shot shot, Wind wind, Tank tank) {
        double y;
        trajectory = new LinkedList<>();
        double windPower = switch (wind.getDirection()) {
            case LEFT -> -wind.getPower();
            case RIGHT -> wind.getPower();
            default -> 0;
        };
        if (shot.getAngle() < Math.PI / 2) {
            for (int x = 0; x < 200 - tank.getCoordinaten().getX(); x++) {
                y = calculate(shot, windPower, tank, x);
                trajectory.add(new Coordinates(x + tank.getCoordinaten().getX(), (int) Math.round(y)));
            }
        } else
            for (int x = 0; x > -tank.getCoordinaten().getX() - 1; x--) {
                y = calculate(shot, windPower, tank, x);
                trajectory.add(new Coordinates((tank.getCoordinaten().getX()) + x, (int) Math.round(y)));
            }
    }

    private double calculate(Shot shot, double windPower, Tank tank, int x) {
        double deel1, deel2, deel3;
        deel1 = -(9.81 / 2) / Math.pow(shot.getVelocity() * Math.cos(shot.getAngle()) - windPower, 2);
        deel2 = Math.sin(shot.getAngle()) / (Math.cos(shot.getAngle()) - (windPower / shot.getVelocity()));
        deel3 = 119 - tank.getCoordinaten().getY();
        return deel1 * Math.pow(x, 2) + deel2 * x + deel3;
    }

    public List<Coordinates> getTrajectory() {
        return trajectory;
    }

    public ImpactType getImpactType() {
        return impactType;
    }

    public void setImpactType(ImpactType impactType) {
        this.impactType = impactType;
    }

    public List<Coordinates> getImpactRadius() {
        return impactRadius;
    }

    public void setImpactRadius(Coordinates impactPoint, boolean isDirt) {
        impactRadius = new LinkedList<>();
        int x = impactPoint.getX();
        int y = impactPoint.getY();
        basicImpact(x, y);
        for (int i = 1; i < (5 - AngryTanksModel.difficulty + (isDirt ? 0 : -1)); i++) {
            extraImpact(i, x, y);
        }
    }

    private void basicImpact(int x, int y) {
        impactRadius.add(new Coordinates(x, y));
        impactRadius.add(new Coordinates(x + 1, y));
        impactRadius.add(new Coordinates(x, y + 1));
        impactRadius.add(new Coordinates(x - 1, y));
        impactRadius.add(new Coordinates(x, y - 1));
    }

    private void extraImpact(int i, int x, int y) {
        impactRadius.add(new Coordinates(x + i + 1, y));
        impactRadius.add(new Coordinates(x, y + i + 1));
        impactRadius.add(new Coordinates(x - i - 1, y));
        impactRadius.add(new Coordinates(x, y - i - 1));
        if (i == 1) {
            impactRadius.add(new Coordinates(x + i, y + i));
            impactRadius.add(new Coordinates(x - i, y - i));
            impactRadius.add(new Coordinates(x + i, y - i));
            impactRadius.add(new Coordinates(x - i, y + i));
        } else {
            impactRadius.add(new Coordinates(x + i, y + i - (i - 1)));
            impactRadius.add(new Coordinates(x + i - (i - 1), y + i));
            impactRadius.add(new Coordinates(x - i, y - i + (i - 1)));
            impactRadius.add(new Coordinates(x - i + (i - 1), y - i));
            impactRadius.add(new Coordinates(x - i, y + i - (i - 1)));
            impactRadius.add(new Coordinates(x - i + (i - 1), y + i));
            impactRadius.add(new Coordinates(x + i, y - i + (i - 1)));
            impactRadius.add(new Coordinates(x + i - (i - 1), y - i));
            if (i == 3) {
                impactRadius.add(new Coordinates(x + i - 1, y + i - 1));
                impactRadius.add(new Coordinates(x - i + 1, y - i + 1));
                impactRadius.add(new Coordinates(x + i - 1, y - i + 1));
                impactRadius.add(new Coordinates(x - i + 1, y + i - 1));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trajectory{");
        for (Coordinates c : trajectory) {
            String string = "[" + c.getX() + "," + c.getY() + "]";
            sb.append(string);
        }
        sb.append("}");
        return sb.toString();
    }
}
