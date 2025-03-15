package AngryTanks.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;
import java.util.List;

import static AngryTanks.model.ImpactType.*;

public class AngryTanksModel {
    private List<Player> players;
    private Wind wind;
    private Landscape landscape;
    private Player activePlayer;
    private List<String> playerNames;
    private DoubleProperty volume;
    public static int difficulty;

    public AngryTanksModel() {
        players = new ArrayList<>();
        wind = new Wind();
        landscape = new Landscape();
        playerNames = new ArrayList<>();
        difficulty = 1;
        volume = new SimpleDoubleProperty(0.5);
    }

    public DoubleProperty volumeProperty() {
        return volume;
    }

    public double getVolume() {
        return volume.get();
    }

    public void setVolume(double volume) {
        this.volume.set(volume);
    }

    public void addPlayers() {
        for (int i = 0; i < playerNames.size(); i++) {
            String playerName = playerNames.get(i);
            char[][] terrain = landscape.getTerrain();
            int x = terrain[0].length / (playerNames.size() - 1);
            int x2 = 0;
            if (i != 0) {
                x2 = 1;
            }
            for (int j = 1; j < terrain.length; j++) {
                if (terrain[j][i * x - x2] == '.' && terrain[j - 1][i * x - x2] == '#') {
                    int y;
                    if (i * x - x2 < terrain.length / 2) {
                        y = 7;
                    } else {
                        y = -7;
                    }
                    players.add(new Player(playerName, new Tank(new Coordinates(i * x - x2 + y, j - 6), i * x - x2 < terrain[0].length / 2)));
                }
            }
        }
        activePlayer = players.get(0);
        landscape.addTanks(players);
    }

    public boolean nextTurn(double angle, double velocity) {
        Trajectory tr;
        if (!activePlayer.getTank().isFacingRight()) {
            tr = activePlayer.playTurn(wind, 180 - angle, velocity);
        } else {
            tr = activePlayer.playTurn(wind, angle, velocity);
        }
        tr.setImpactType(landscape.updateLandscape(tr, activePlayer));
        if (tr.getImpactType() == HIT) {
            for (Player player : players) {
                if (player != activePlayer) {
                    player.getTank().setLives(player.getTank().getLives() - 2);
                }
            }
        } else if (tr.getImpactType() == BLAST) {
            for (Player player : players) {
                if (player != activePlayer) {
                    player.getTank().setLives(player.getTank().getLives() - 1);
                }
            }
        }
        wind.generateWind();
        if (checkWinner() != null) {
            return true;
        }
        for (Player player : players) {
            if (activePlayer != player) {
                activePlayer = player;
                return false;
            }
        }
        return false;
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
        Player player = null;
        int alive = 0;
        for (Player p : players) {
            if (p.getTank().getLives() < 1) {
                player = p;
                alive++;
            }
        }
        if (alive > 1) {
            player = null;
        }
        return player;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void eliminateWind(int windValue){
        wind.setWindOff(windValue);
    }
}
