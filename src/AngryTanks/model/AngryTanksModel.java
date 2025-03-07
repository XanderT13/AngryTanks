package AngryTanks.model;

import java.util.ArrayList;
import java.util.List;

public class AngryTanksModel {
    private List<Player> players;
    private Wind wind;
    private Landscape landscape;

    public AngryTanksModel(int amount) {
        players = new ArrayList<Player>();
        wind = new Wind();
        landscape = new Landscape();
        for (int i = 0; i < amount; i++) {
            String playerName = "Player " + (i + 1);
        }
        playGame();
    }

    public void playGame() {
        do {
            for (Player player : players) {
                wind.generateWind();
                System.out.println("Wind: " + Math.round(wind.getPower()) + ", " + wind.getDirection());
                player.playTurn(wind);
            }
        }
        while (checkWinner() == null);
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

    public Player checkWinner() {
        Player player = null;
        int alive = 0;
        for (Player p : players) {
            if(!p.getTank().isDead()){
                player = p;
                alive++;
            }
        }
        if (alive > 1) {
            player = null;
        }
        return player;
    }
}
