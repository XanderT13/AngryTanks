package AngryTanks.model;

import java.util.ArrayList;
import java.util.List;

public class AngryTanksModel {
    private List<Player> players;
    private Wind wind;
    private Landscape landscape;

    public AngryTanksModel(){
        players = new ArrayList<Player>();
        wind = new Wind();
        landscape = new Landscape();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Wind getWind() {
        return wind;
    }

    public Landscape getLandscape() {
        return landscape;
    }
}
