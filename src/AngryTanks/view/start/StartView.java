package AngryTanks.view.start;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class StartView extends GridPane {
    // private Node attributen (controls)
    private Button playButton;
    private ImageView startSchermImage;
    private Button settingsButton;
    private TextField name1;
    private TextField name2;

    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        playButton = new Button("PLAY");

        startSchermImage = new ImageView();

        settingsButton = new Button();

        name1 = new TextField();
        name2 = new TextField();
    }

    private void layoutNodes() {
        // adding stylesheet
        this.getStylesheets().add("/style.css");
        this.setAlignment(Pos.CENTER);
        // achtergrond via CSS
        this.getStyleClass().add("start-view");

        settingsButton.setPrefSize(75, 75);
        settingsButton.getStyleClass().add("settings-button");
        settingsButton.setOnMouseEntered(e -> settingsButton.setStyle(
                "-fx-border-color: Black; " +
                        "-fx-border-width: 2;"
        ));
        settingsButton.setOnMouseExited(e -> settingsButton.setStyle(
                "-fx-border-color: lightgray; " +
                        "-fx-border-width: 2;"
        ));
        this.add(settingsButton, 2, 4);
        GridPane.setHalignment(settingsButton, HPos.CENTER);

        this.setGridLinesVisible(false);
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHgrow(Priority.ALWAYS);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(column1, column2, column3);
        RowConstraints row1 = new RowConstraints();
        row1.setVgrow(Priority.ALWAYS);
        RowConstraints row2 = new RowConstraints();
        row2.setVgrow(Priority.ALWAYS);
        RowConstraints row3 = new RowConstraints();
        row3.setVgrow(Priority.ALWAYS);
        RowConstraints row4 = new RowConstraints();
        row4.setVgrow(Priority.ALWAYS);
        RowConstraints row5 = new RowConstraints();
        row5.setVgrow(Priority.ALWAYS);
        this.getRowConstraints().addAll(row1, row2, row3, row4, row5);


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
        this.add(playButton, 1, 4);
        playButton.setPrefSize(120, 40);
        GridPane.setHalignment(playButton, HPos.CENTER);

        GridPane.setColumnSpan(startSchermImage, 3);
        GridPane.setRowSpan(startSchermImage, 5);
        this.add(startSchermImage, 0, 0);

        name1.setMaxWidth(250);
        this.add(name1, 1, 2);
        this.setHalignment(name1, HPos.LEFT);
        name2.setMaxWidth(250);
        this.add(name2, 1, 2);
        this.setHalignment(name2, HPos.RIGHT);
    }

    // implementatie van de nodige
    // package-private Getters
    Button getPlayButton() {
        return playButton;
    }

    Button getSettingsButton() {
        return settingsButton;
    }

    public TextField getName1() {
        return name1;
    }

    public TextField getName2() {
        return name2;
    }

}
