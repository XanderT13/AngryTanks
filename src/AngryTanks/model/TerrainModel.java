package AngryTanks.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TerrainModel {
    private char[][] terrain;
    private static final String FILE_PATH = "/terrain_poging1.txt"; // Bestand in resources zetten

    public TerrainModel() {
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
}
