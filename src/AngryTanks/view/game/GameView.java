package AngryTanks.view.game;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GameView extends BorderPane {
    private static final String CONTROL_BACKGROUND = "/controlGrid_back.png";
    private Label player1Label, player2Label, previousTurn1, previousTurn2, windLabel;
    private Label velocityLabel, angleLabel, velSliderLabel, angleSliderLabel;
    private Slider velocitySlider, angleSlider;
    private Button settingsButton, fireButton;
    private HBox topBox, healthBox1, healthBox2;
    private Circle life1, life2, life3, life4, life5, life6;
    private GridPane controlGrid, gameGrid;

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        player1Label = new Label("Player 1");
        player2Label = new Label("Player 2");
        previousTurn1 = new Label();
        previousTurn2 = new Label();
        windLabel = new Label("Wind");
        velocityLabel = new Label("Velocity");
        angleLabel = new Label("Angle");

        velocitySlider = new Slider(0, 50, 25);
        velocitySlider.setOrientation(Orientation.VERTICAL);
        velocitySlider.getStyleClass().add("cool-slider");

        angleSlider = new Slider(0, 90, 45);
        angleSlider.setOrientation(Orientation.VERTICAL);
        angleSlider.getStyleClass().add("cool-slider");

        fireButton = new Button("FIRE!");
        fireButton.getStyleClass().add("fire-button");

        settingsButton = new Button();
        settingsButton.getStyleClass().add("settings-button");

        controlGrid = new GridPane();
        gameGrid = new GridPane();

        life1 = new Circle(15, Color.GREEN);
        life2 = new Circle(15, Color.GREEN);
        life3 = new Circle(15, Color.GREEN);
        life4 = new Circle(15, Color.GREEN);
        life5 = new Circle(15, Color.GREEN);
        life6 = new Circle(15, Color.GREEN);
        healthBox1 = new HBox(2, life1, life2, life3);
        healthBox1.setAlignment(Pos.CENTER);
        healthBox2 = new HBox(2, life4, life5, life6);
        healthBox2.setAlignment(Pos.CENTER);

        topBox = new HBox(20, previousTurn1, player1Label, healthBox1, windLabel, player2Label, healthBox2, previousTurn2);
        topBox.setAlignment(Pos.CENTER);
        topBox.getStyleClass().add("top-box");

        velSliderLabel = new Label();
        velSliderLabel.textProperty().bind(Bindings.format("%.0f", velocitySlider.valueProperty()));
        velSliderLabel.getStyleClass().add("slider-label");

        angleSliderLabel = new Label();
        angleSliderLabel.textProperty().bind(Bindings.format("%.0f", angleSlider.valueProperty()));
        angleSliderLabel.getStyleClass().add("slider-label");
    }

    private void layoutNodes() {
        this.getStylesheets().add("/style.css");
        this.setPrefSize(1260, 700);
        this.setPadding(new Insets(10));

        controlGrid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        controlGrid.getColumnConstraints().addAll(new ColumnConstraints(100), new ColumnConstraints(100));
        controlGrid.getRowConstraints().addAll(new RowConstraints(), new RowConstraints(), new RowConstraints(100), new RowConstraints(80));

        controlGrid.add(velocityLabel, 0, 0);
        controlGrid.setHalignment(velocityLabel, HPos.CENTER);
        controlGrid.add(angleLabel, 1, 0);
        controlGrid.setHalignment(angleLabel, HPos.CENTER);

        controlGrid.add(velocitySlider, 0, 1);
        controlGrid.add(velSliderLabel, 0, 1);
        controlGrid.setHalignment(velocitySlider, HPos.CENTER);

        controlGrid.add(angleSlider, 1, 1);
        controlGrid.add(angleSliderLabel, 1, 1);
        controlGrid.setHalignment(angleSlider, HPos.CENTER);

        controlGrid.add(fireButton, 0, 2);
        controlGrid.setColumnSpan(fireButton, 2);
        controlGrid.setHalignment(fireButton, HPos.CENTER);

        controlGrid.add(settingsButton, 0, 3);
        controlGrid.setColumnSpan(settingsButton, 2);
        controlGrid.setHalignment(settingsButton, HPos.CENTER);

        this.setTop(topBox);
        this.setCenter(gameGrid);
        this.setRight(controlGrid);
    }

Label getPlayer1Label() {
        return player1Label;
    }

     Label getPlayer2Label() {
        return player2Label;
    }

     Label getPreviousTurn1() {
        return previousTurn1;
    }

     Label getPreviousTurn2() {
        return previousTurn2;
    }

     Label getWindLabel() {
        return windLabel;
    }

     Slider getVelocitySlider() {
        return velocitySlider;
    }

     Slider getAngleSlider() {
        return angleSlider;
    }

     Button getSettingsButton() {
        return settingsButton;
    }

     Button getFireButton() {
        return fireButton;
    }

     HBox getHealthBox1() {
        return healthBox1;
    }

     HBox getHealthBox2() {
        return healthBox2;
    }

     GridPane getGameGrid() {
        return gameGrid;
    }

}
