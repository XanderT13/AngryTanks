package AngryTanks.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameHistory {
    private List<Shot> shots;
    private List<Wind> winds;
    private List<Trajectory> trajectories;
    private List<Player> activePlayers;

    //constructor
    public GameHistory() {
        shots = new ArrayList<>();
        winds = new ArrayList<>();
        trajectories = new ArrayList<>();
        activePlayers = new ArrayList<>();
    }

    public void updateHistory(Shot s, Wind w, Trajectory t, Player p) {
        shots.add(s);
        winds.add(w);
        trajectories.add(t);
        activePlayers.add(p);
        int turn = trajectories.size();
        System.out.printf("Turn %d: %s %s %s ImpactType{%s} %s\n", turn, p, s, w, t.getImpactType(), t);
    }

    public void writeToFile(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("gameHistory.txt", true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public List<Shot> getShots() {
        return shots;
    }

    public List<Wind> getWinds() {
        return winds;
    }

    public List<Trajectory> getTrajectories() {
        return trajectories;
    }

    public List<Player> getActivePlayers() {
        return activePlayers;
    }
}
