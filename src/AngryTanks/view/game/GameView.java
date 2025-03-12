package AngryTanks.view.game;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GameView extends BorderPane {
    // private Node attributen (controls)
    private static final String FILENAME = "resources/terrain_poging1.txt";
    private Label player1Label;
    private Label player2Label;
    private Label windLabel;
    private Label velocityLabel;
    private Label angleLabel;
    private Slider velocitySlider;
    private Slider angleSlider;
    private Button settingsButton;
    private Button fireButton;
    private HBox topBox;
    private HBox healthBox1;
    private HBox healthBox2;
    private Circle life1;
    private Circle life2;
    private Circle life3;
    private Circle life4;
    private Circle life5;
    private Circle life6;
    private GridPane controlGrid;
    private GridPane gameGrid;
    private Label bottomLabel;

    public GameView(int width, int height) {
        initialiseNodes();
        layoutNodes();

    }


    public void drawTerrain(char[][] terrain) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            int row = 0;

            while ((line = br.readLine()) != null && row < 60) {
                for (int col = 0; col < Math.min(line.length(), 100); col++) {
                    char ch = line.charAt(col);
                    Rectangle rect = new Rectangle(10, 10);
                    if (ch == '#') rect.setFill(Color.DARKGRAY);
                    if (ch == '.') rect.setFill(Color.DARKGREEN);
                    if (ch == '-') rect.setFill(Color.LIGHTBLUE);
                    if (ch == '/') rect.setFill(Color.YELLOW);
                    if (ch == 'X') rect.setFill(Color.BLACK);
                    gameGrid.add(rect, col, row);
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initialiseNodes() {
        // Initialisatie van de Nodes
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
        player1Label = new Label("Player 1");
        player2Label = new Label("Player 2");
        windLabel = new Label("Wind");
        velocitySlider = new Slider();
        angleSlider = new Slider();
        settingsButton = new Button();
        fireButton = new Button("FIRE!");
        controlGrid = new GridPane();
        gameGrid = new GridPane();
        velocityLabel = new Label("Velocity");
        angleLabel = new Label("Angle");
        bottomLabel = new Label("TRAJECTORY");
        life1 = new Circle(15, Color.GREEN);
        life2 = new Circle(15, Color.GREEN);
        life3 = new Circle(15, Color.GREEN);
        life4 = new Circle(15, Color.GREEN);
        life5 = new Circle(15, Color.GREEN);
        life6 = new Circle(15, Color.GREEN);
        healthBox1 = new HBox(life1, life2, life3);
        healthBox2 = new HBox(life4, life5, life6);
        topBox = new HBox(player1Label, healthBox1, windLabel, player2Label, healthBox2);


    }

    private void layoutNodes() {
        // adding stylesheet
        this.getStylesheets().add("/style.css");
        // setting the parameters for the nodes inside the topBox
        healthBox1.setAlignment(Pos.CENTER);
        healthBox1.setSpacing(2);
        healthBox2.setAlignment(Pos.CENTER);
        healthBox2.setSpacing(2);
        // aligning the topBox
        topBox.setAlignment(Pos.CENTER);
        topBox.setSpacing(50);
        topBox.setStyle("-fx-border-color: black; -fx-border-width: 2");

        // setting the parameters for the elements inside the controlGrid
        velocitySlider.setOrientation(Orientation.VERTICAL);
        velocitySlider.setMin(0);
        velocitySlider.setMax(50);
        velocitySlider.setMajorTickUnit(50);
        velocitySlider.setMinorTickCount(0);
        velocitySlider.setBlockIncrement(1);
        velocitySlider.setShowTickLabels(true);
        velocitySlider.getStyleClass().add("cool-slider");

        angleSlider.setOrientation(Orientation.VERTICAL);
        angleSlider.setMin(0);
        angleSlider.setMax(180);
        angleSlider.setMajorTickUnit(180);
        angleSlider.setMinorTickCount(0);
        angleSlider.setBlockIncrement(1);
        angleSlider.setShowTickLabels(true);
        angleSlider.getStyleClass().add("cool-slider");

        // aligning and filling the controlGrid
        controlGrid.setGridLinesVisible(true);
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(100);
        controlGrid.getColumnConstraints().addAll(column1, column2);
        RowConstraints row1 = new RowConstraints(50);
        RowConstraints row2 = new RowConstraints(350);
        RowConstraints row3 = new RowConstraints(100);
        RowConstraints row4 = new RowConstraints(100);
        controlGrid.getRowConstraints().addAll(row1, row2, row3, row4);
        controlGrid.add(velocityLabel, 0, 0);
        controlGrid.setHalignment(velocityLabel, HPos.CENTER);
        controlGrid.add(angleLabel, 1, 0);
        controlGrid.setHalignment(angleLabel, HPos.CENTER);
        controlGrid.add(velocitySlider, 0, 1);
        controlGrid.setHalignment(velocitySlider, HPos.CENTER);
        controlGrid.add(angleSlider, 1, 1);
        controlGrid.setHalignment(angleSlider, HPos.CENTER);
        // spicing up the fireButton
        fireButton.setPrefSize(80,80);
        fireButton.setStyle("-fx-background-color: lightcoral;" +
                "-fx-text-fill: white; " +
                "-fx-background-radius: 50; " + // Zorgt voor ronde knop
                "-fx-min-width: 50px; " +
                "-fx-min-height: 50px; " +
                "-fx-border-radius: 50; " +
                "-fx-border-color: darkred; " +
                "-fx-border-width: 2;");
        fireButton.setOnMouseEntered(e -> fireButton.setStyle(
                "-fx-background-color: darkred; " +  // Donkerrood bij hover
                        "-fx-text-fill: white; " +
                        "-fx-background-radius: 50; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-border-radius: 50; " +
                        "-fx-border-color: darkred; " +
                        "-fx-border-width: 2;"
        ));
        fireButton.setOnMouseExited(e -> fireButton.setStyle(
                "-fx-background-color: lightcoral; " +  // Terug naar lichtrood
                        "-fx-text-fill: white; " +
                        "-fx-background-radius: 50; " +
                        "-fx-min-width: 50px; " +
                        "-fx-min-height: 50px; " +
                        "-fx-border-radius: 50; " +
                        "-fx-border-color: darkred; " +
                        "-fx-border-width: 2;"
        ));
        controlGrid.add(fireButton, 0,2);
        controlGrid.setColumnSpan(fireButton, 2);
        controlGrid.setHalignment(fireButton, HPos.CENTER);

        settingsButton.setPrefSize(75,75);
        settingsButton.getStyleClass().add("settings-button");
        settingsButton.setOnMouseEntered(e -> settingsButton.setStyle(
                        "-fx-border-color: Black; " +
                        "-fx-border-width: 2;"
        ));
        settingsButton.setOnMouseExited(e -> settingsButton.setStyle(
                        "-fx-border-color: lightgray; " +
                        "-fx-border-width: 2;"
        ));
        controlGrid.add(settingsButton, 0,3);
        controlGrid.setColumnSpan(settingsButton, 2);
        controlGrid.setHalignment(settingsButton, HPos.CENTER);


        // now we fill the BorderPane and align it
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setTop(topBox);
        this.setCenter(gameGrid);
        this.setRight(controlGrid);
        this.setBottom(bottomLabel);
        this.setCenter(gameGrid);


    }
    // implementatie van de nodige
    // package-private Getters

    Label getPlayer1Label() {
        return player1Label;
    }

    Label getPlayer2Label() {
        return player2Label;
    }

    Label getWindLabel() {
        return windLabel;
    }

    Label getVelocityLabel() {
        return velocityLabel;
    }

    Label getAngleLabel() {
        return angleLabel;
    }

    Slider getAngleSlider() {
        return angleSlider;
    }

    Slider getVelocitySlider() {
        return velocitySlider;
    }

    Button getSettingsButton() {
        return settingsButton;
    }

    Button getFireButton() {
        return fireButton;
    }

    Circle getLife1() {
        return life1;
    }

    Circle getLife2() {
        return life2;
    }

    Circle getLife3() {
        return life3;
    }

    Circle getLife4() {
        return life4;
    }

    Circle getLife5() {
        return life5;
    }

    Circle getLife6() {
        return life6;
    }

    Label getBottomLabel() {
        return bottomLabel;
    }

    HBox getTopBox() {
        return topBox;
    }

    HBox getHealthBox1() {
        return healthBox1;
    }

    HBox getHealthBox2() {
        return healthBox2;
    }

    GridPane getControlGrid() {
        return controlGrid;
    }

    GridPane getGameGrid() {
        return gameGrid;
    }
}

