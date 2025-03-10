package AngryTanks.model;

import java.util.LinkedList;
import java.util.List;

public class GameHistory {
    private List<Landscape> landscapes;
    private List<Shot> schots;
    private List<Wind> winds;
    private List<Trajectory> trajectories;

    //constructor
    public GameHistory() {
        landscapes = new LinkedList<>();
        schots = new LinkedList<>();
        winds = new LinkedList<>();
        trajectories = new LinkedList<>();
    }

    public void updateHistory(Landscape l, Shot s, Wind w, Trajectory t) {
        landscapes.add(l);
        schots.add(s);
        winds.add(w);
        trajectories.add(t);
    }
}
