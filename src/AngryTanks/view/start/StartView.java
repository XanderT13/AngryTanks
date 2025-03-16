package AngryTanks.view.start;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

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
        this.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        this.setAlignment(Pos.CENTER);

        // achtergrond via CSS
        this.getStyleClass().add("start-view");
        settingsButton.getStyleClass().add("settings-button");
        playButton.getStyleClass().add("play-button");

        this.add(settingsButton, 2, 4);
        GridPane.setHalignment(settingsButton, HPos.CENTER);

        this.setGridLinesVisible(false);
        ColumnConstraints column = new ColumnConstraints();
        column.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().addAll(column, column, column);

        RowConstraints row = new RowConstraints();
        row.setVgrow(Priority.ALWAYS);
        this.getRowConstraints().addAll(row, row, row, row, row);

        this.add(playButton, 1, 4);
        GridPane.setHalignment(playButton, HPos.CENTER);

        GridPane.setColumnSpan(startSchermImage, 3);
        GridPane.setRowSpan(startSchermImage, 5);
        this.add(startSchermImage, 0, 0);

        name1.setMaxWidth(250);
        name1.getStyleClass().add("player-name");
        this.add(name1, 1, 2);
        GridPane.setHalignment(name1, HPos.LEFT);

        name2.setMaxWidth(250);
        name2.getStyleClass().add("player-name");
        this.add(name2, 1, 2);
        GridPane.setHalignment(name2, HPos.RIGHT);
    }

    // implementatie van de nodige package-private Getters
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
