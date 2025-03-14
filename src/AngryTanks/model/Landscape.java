package AngryTanks.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import static AngryTanks.model.ImpactType.*;
import static AngryTanks.model.ImpactType.MISS;

public class Landscape {
    private char[][] terrain;
    private static final String FILE_PATH = "/landscape_120x200.txt"; // Bestand in resources zetten

    public Landscape() {
        loadTerrain();
    }

    private void loadTerrain() {
        InputStream inputStream = getClass().getResourceAsStream(FILE_PATH);
        if (inputStream == null) {
            System.err.println("Bestand niet gevonden: " + FILE_PATH);
            terrain = new char[0][0];
            return;
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            terrain = reader.lines().map(String::toCharArray).toArray(char[][]::new);
        } catch (IOException e) {
            e.printStackTrace();
            terrain = new char[0][0]; // Fallback voor lege terrain
        }
    }

    public char[][] getTerrain() {
        return terrain;
    }

    public void addTanks(List<Player> players) {
        for (Player player : players) {
            for (Coordinates c : player.getTank().getTankCoordinates())
                terrain[c.getY()][c.getX()] = 'A';
        }
    }

    public ImpactType updateLandscape(Trajectory trajectory, Player activePlayer) {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                if (terrain[i][j] == 'X') {
                    terrain[i][j] = '#';
                } else if (terrain[i][j] == 'Y') {
                    terrain[i][j] = '/';
                }
                else if (terrain[i][j] == 'Z') {
                    terrain[i][j] = 'A';
                }
            }
        }
        for (Coordinates cPlayer : activePlayer.getTank().getTankCoordinates()) {
            terrain[cPlayer.getY()][cPlayer.getX()] = 'Z';
        }
        for (Coordinates c : trajectory.getTrajectory()) {
            int y = terrain.length - 1 - c.getY();
            int x = c.getX();
            if (c.getY() >= 0 && c.getY() < terrain.length) {
                if (terrain[y][x] == '#') {
                    terrain[y][x] = 'X';
                } else if (terrain[y][x] == '/') {
                    terrain[y][x] = 'Y';
                } else if (terrain[y][x] == '.') {
                    terrain[y][x] = 'X';
                    trajectory.setImpactRadius(new Coordinates(x, y), true);
                    for (Coordinates impactC : trajectory.getImpactRadius()) {
                        int impactX = impactC.getX();
                        int impactY = impactC.getY();
                        if (terrain[impactY][impactX] == '-' || terrain[impactY][impactX] == '.') {
                            terrain[impactY][impactX] = '#';
                        }
                        if (terrain[impactY][impactX] == 'A') {
                            return BLAST;
                        }
                    }
                    return LAND;
                } else if (terrain[y][x] == '-') {
                    terrain[y][x] = 'X';
                    trajectory.setImpactRadius(new Coordinates(x, y), false);
                    for (Coordinates impactC : trajectory.getImpactRadius()) {
                        int impactX = impactC.getX();
                        int impactY = impactC.getY();
                        if (terrain[impactY][impactX] == '-' || terrain[impactY][impactX] == '.') {
                            terrain[impactY][impactX] = '#';
                        }
                        if (terrain[impactY][impactX] == 'A') {
                            return BLAST;
                        }
                    }
                    return LAND;
                } else if (terrain[y][x] == 'A') {
                    return HIT;
                }
            }
        }
        return MISS;
    }
}
