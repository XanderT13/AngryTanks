package AngryTanks.view.start;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class StartView extends GridPane {
    // private Node attributen (controls)
    private Button playButton;
    private ImageView startSchermImage;
    private Button settingsButton;

    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        playButton = new Button("PLAY");

        startSchermImage = new ImageView();

        settingsButton = new Button();
    }
    private void layoutNodes() {
        // adding stylesheet
        this.getStylesheets().add("/style.css");
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);
        // achtergrond via CSS
        this.getStyleClass().add("start-view");

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
        this.add(settingsButton, 2, 5);
        GridPane.setHalignment(settingsButton, HPos.CENTER);

        this.setGridLinesVisible(false);
        ColumnConstraints column1 = new ColumnConstraints(200);
        ColumnConstraints column2 = new ColumnConstraints(700);
        ColumnConstraints column3 = new ColumnConstraints(200);
        this.getColumnConstraints().addAll(column1, column2, column3);
        RowConstraints row1 = new RowConstraints(80);
        RowConstraints row2 = new RowConstraints(80);
        RowConstraints row3 = new RowConstraints(80);
        RowConstraints row4 = new RowConstraints(80);
        RowConstraints row5 = new RowConstraints(140);
        RowConstraints row6 = new RowConstraints(80);
        this.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6);


        playButton.getStyleClass().add("play-button");
        playButton.setOnMouseEntered(e -> playButton.setStyle(
                "-fx-background-color: darkgreen; " +  // Donkerrood bij hover
                        "-fx-border-color: gray; " +
                        "-fx-border-width: 2;"
        ));
        playButton.setOnMouseExited(e -> playButton.setStyle(
                "-fx-background-color: green; " +  // Terug naar lichtrood
                        "-fx-border-color: black; " +
                        "-fx-border-width: 2;"
        ));
        this.add(playButton, 1, 5);
        playButton.setPrefSize(120,40);
        GridPane.setHalignment(playButton, HPos.CENTER);

        GridPane.setColumnSpan(startSchermImage, 3);
        GridPane.setRowSpan(startSchermImage, 5);
        this.add(startSchermImage, 0, 0);


    }

    // implementatie van de nodige
    // package-private Getters
    Button getPlayButton() {

        return playButton;
    }
    Button getSettingsButton() {
        return settingsButton;
    }

}
