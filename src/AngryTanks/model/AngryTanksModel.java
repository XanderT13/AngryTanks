package AngryTanks.model;

import java.util.ArrayList;
import java.util.List;

public class AngryTanksModel {
    private List<Player> players;
    private Wind wind;
    private Landscape landscape;
    private Player activePlayer;

    public AngryTanksModel(int amount) {
        players = new ArrayList<Player>();
        wind = new Wind();
        landscape = new Landscape();
        for (int i = 0; i < amount; i++) {
            String playerName = "Player " + (i + 1);
            char[][] terrain = landscape.getTerrain();
            int x = terrain[0].length / (amount - 1);
            int x2 = 0;
            if (i != 0) {
                x2 = 1;
            }
            for (int j = 1; j < terrain.length; j++) {
                if (terrain[j][i * x - x2] == '.' && terrain[j - 1][i * x - x2] == '-') {
                    players.add(new Player(playerName, new Tank(new Coordinates(i * x - x2, j - 1))));
                }
            }
        }
        activePlayer = players.get(0);
        landscape.addTanks(players);
    }

    public void nextTurn(double angle, double velocity) {
        List<Coordinates> tr = activePlayer.playTurn(wind, angle, velocity).getTrajectory();
        landscape.updateLandscape(tr);
        wind.generateWind();
        if (checkWinner() != null) {
            return;
        }
        for (Player player : players) {
            if (activePlayer != player) {
                activePlayer = player;
                return;
            }
        }
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

    public Player getActivePlayer() {
        return activePlayer;
    }

    public Player checkWinner() {
       /*Player player = null;
        int alive = 0;
        for (Player p : players) {
            if (!p.getTank().isDead()) {
                player = p;
                alive++;
            }
        }
        if (alive > 1) {
            player = null;
        }
        return player;*/
        return null;
    }
}
