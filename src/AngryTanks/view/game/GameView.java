package AngryTanks.view.game;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GameView extends GridPane {
    // private Node attributen (controls)
    private Canvas canvas;
    private static final int TILE_SIZE = 60;

    public GameView(int width, int height) {
        canvas = new Canvas(width * TILE_SIZE, height*TILE_SIZE);
        this.getChildren().add(canvas);
        this.initialiseNodes();
        this.layoutNodes();
    }


    public void drawTerrain(char[][] terrain) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // canvas clearen voor erop te tekenen
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //achtergrond vullen
        gc.setFill(Color.GRAY);
        gc.fillRect(0,0,canvas.getWidth(), canvas.getHeight());
        // grond tekenen
        gc.setFill(Color.BLACK);
        for (int row = 0; row < terrain.length; row++) {
            for (int col = 0; col < terrain[row].length; col++) {
                if (terrain[row][col] == '#') {
                    gc.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
        }
    }
    private void initialiseNodes() {
        // Initialisatie van de Nodes
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")




    }
    private void layoutNodes() {
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …


    }
    // implementatie van de nodige
    // package-private Getters

}
