package AngryTanks.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Landscape {
    private char[][] terrain;
    private static final String FILE_PATH = "/terrain_poging1.txt"; // Bestand in resources zetten

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
            for (Coordinates c: player.getTank().getTankCoordinates())
              terrain[c.getY()][c.getX()] = 'Z';
        }
    }

    public void updateLandscape(List<Coordinates> trajectory) {
        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[0].length; j++) {
                if (terrain[i][j] == 'X') {
                    terrain[i][j] = '-';
                } else if (terrain[i][j] == 'Y') {
                    terrain[i][j] = '/';
                }
            }
        }
        for (Coordinates c : trajectory) {
            if (c.getY() >= 0 && c.getY() < terrain.length && (terrain[terrain.length - 1 - c.getY()][c.getX()] == '-' || terrain[terrain.length - 1 - c.getY()][c.getX()] == '/')) {
                if (terrain[terrain.length - 1 - c.getY()][c.getX()] == '-') {
                    terrain[terrain.length - 1 - c.getY()][c.getX()] = 'X';
                } else if (terrain[terrain.length - 1 - c.getY()][c.getX()] == '/') {
                    terrain[terrain.length - 1 - c.getY()][c.getX()] = 'Y';
                }
            }
        }
    }
}
