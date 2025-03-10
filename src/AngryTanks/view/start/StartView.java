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
    private Label atLabel;
    private ImageView startSchermImage;
    private ImageView leftTank;
    private Button settingsButton;

    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        playButton = new Button("PLAY");

        atLabel = new Label("Angry Tanks");
        atLabel.setStyle("-fx-font-weight: bold");
        atLabel.setStyle("-fx-font-size: 16");

        startSchermImage = new ImageView();
        leftTank = new ImageView();

        settingsButton = new Button("Settings");
    }
    private void layoutNodes() {
        // adding stylesheet
        this.getStylesheets().add(("/style.css"));
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);
        // achtergrond via CSS
        this.getStyleClass().add("start-view");

        this.setGridLinesVisible(true);
        ColumnConstraints column1 = new ColumnConstraints(200);
        ColumnConstraints column2 = new ColumnConstraints(700);
        ColumnConstraints column3 = new ColumnConstraints(200);
        this.getColumnConstraints().addAll(column1, column2, column3);
        RowConstraints row1 = new RowConstraints(80);
        RowConstraints row2 = new RowConstraints(80);
        RowConstraints row3 = new RowConstraints(80);
        RowConstraints row4 = new RowConstraints(80);
        RowConstraints row5 = new RowConstraints(80);
        RowConstraints row6 = new RowConstraints(80);
        this.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6);

        this.add(playButton, 1, 5);
        playButton.setPrefSize(120,40);
        GridPane.setHalignment(playButton, HPos.CENTER);

        this.add(atLabel, 1, 0);
        atLabel.setPrefSize(120,40);
        GridPane.setHalignment(atLabel, HPos.CENTER);

        GridPane.setColumnSpan(startSchermImage, 3);
        GridPane.setRowSpan(startSchermImage, 5);
        this.add(startSchermImage, 0, 0);

        this.add(leftTank, 0, 3);

        this.add(settingsButton, 2, 5);
        settingsButton.setPrefSize(100,50);
        GridPane.setHalignment(settingsButton, HPos.CENTER);

    }

    // implementatie van de nodige
    // package-private Getters
    Button getPlayButton() {
        return playButton;
    }

    Label getAtLabel() {
        return atLabel;
    }

}
