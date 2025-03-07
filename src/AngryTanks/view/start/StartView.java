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
    private Image startScherm;
    private ImageView startSchermImage;
    //private Label difLabel;
    //private Label numberOfPlayers;
    private Button settingsButton;
    //private Slider nopSlider;
    //private Slider botSlider;
    //private Label botLabel;
    //private CheckBox easyBox;
    //private CheckBox intermediateBox;
    //private CheckBox expertBox;

    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();
        this.applyStyles();
    }
    private void initialiseNodes() {
        playButton = new Button("PLAY");

        atLabel = new Label("Angry Tanks");
        atLabel.setStyle("-fx-font-weight: bold");
        atLabel.setStyle("-fx-font-size: 16");

        startScherm = new Image("/startscherm.jpg");
        startSchermImage = new ImageView();

        //difLabel = new Label("Difficulty");
        //difLabel.setStyle("-fx-font-weight: bold");
        //difLabel.setStyle("-fx-font-size: 12");

        //numberOfPlayers = new Label("Number of Players:");
        //numberOfPlayers.setStyle("-fx-font-weight: bold");
        //numberOfPlayers.setStyle("-fx-font-size: 12");

        settingsButton = new Button("Settings");

        //nopSlider = new Slider();
        //nopSlider.setMin(1);
        //nopSlider.setMax(4);
        //nopSlider.setShowTickLabels(true);
        //nopSlider.setSnapToTicks(true);
        //nopSlider.setMajorTickUnit(1);
        //nopSlider.setMinorTickCount(0);

        //botSlider = new Slider();
        //botSlider.setMin(0);
        //botSlider.setMax(3);
        //botSlider.setShowTickLabels(true);
        //botSlider.setSnapToTicks(true);
        //botSlider.setMajorTickUnit(1);
        //botSlider.setMinorTickCount(0);

        //botLabel = new Label("Number of Bots:");
        //botLabel.setStyle("-fx-font-weight: bold");
        //botLabel.setStyle("-fx-font-size: 12");

        //easyBox = new CheckBox("Easy");
        //intermediateBox = new CheckBox("Intermediate");
        //expertBox = new CheckBox("Expert");
    }
    private void layoutNodes() {
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);
        // aachtergrond via CSS
        this.getStyleClass().add("start-view")  ;

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

        //this.add(difLabel, 1, 1);
        //difLabel.setPrefSize(120,40);
        //GridPane.setHalignment(difLabel, HPos.CENTER);

        //this.add(numberOfPlayers, 0, 3);
        //numberOfPlayers.setPrefSize(120,20);
        //GridPane.setHalignment(numberOfPlayers, HPos.CENTER);

        this.add(settingsButton, 2, 5);
        settingsButton.setPrefSize(100,50);
        GridPane.setHalignment(settingsButton, HPos.CENTER);

        //this.add(nopSlider, 1, 3);
        //nopSlider.setPrefSize(600,20);
        //GridPane.setMargin(nopSlider, new Insets(10,30,10,30));

        //this.add(botSlider, 1, 4);
        //botSlider.setPrefSize(600,20);
        //GridPane.setMargin(botSlider, new Insets(10,30,10,30));

        //this.add(botLabel, 0, 4);
        //botLabel.setPrefSize(120,20);
        //GridPane.setHalignment(botLabel, HPos.CENTER);

        //this.add(easyBox, 1, 2);
        //easyBox.setPrefSize(100,20);
        //GridPane.setHalignment(easyBox, HPos.LEFT);
        //GridPane.setMargin(easyBox, new Insets(10,10,10,30));

        //this.add(intermediateBox, 1, 2);
        //intermediateBox.setPrefSize(100,20);
        //GridPane.setHalignment(intermediateBox, HPos.CENTER);

        //this.add(expertBox, 1, 2);
        //expertBox.setPrefSize(100,20);
        //GridPane.setHalignment(expertBox, HPos.RIGHT);

    }

    private void applyStyles(){
        this.getStylesheets().add(("/style.css"));
    }
    // implementatie van de nodige
    // package-private Getters
    Button getPlayButton() { return playButton; }
    Label getAtLabel() { return atLabel; }
    //Label getDifLabel() { return difLabel; }
    //Label getNumberOfPlayers() { return numberOfPlayers; }
    //Button getSettingsButton() { return settingsButton; }
    //Label getBotLabel() { return botLabel; }
    //CheckBox getEasyBox() { return easyBox; }
    //CheckBox getIntermediateBox() { return intermediateBox; }
    //CheckBox getExpertBox() { return expertBox; }
}
