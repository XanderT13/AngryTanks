package AngryTanks.model;

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
        System.out.println("Turn " + turn + ": " + p + " " + s + " " + w + " ImpactType{" + t.getImpactType() + "} " + t);
    }
}
