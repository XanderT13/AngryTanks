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

public class GameView extends BorderPane {
    // private Node attributen (controls)
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
        settingsButton = new Button("Settings");
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
        // setting the parameters for the nodes inside the topBox
        healthBox1.setAlignment(Pos.CENTER);
        healthBox1.setSpacing(5);
        healthBox2.setAlignment(Pos.CENTER);
        healthBox2.setSpacing(5);
        // first we align the Hbox that will be placed in the top of the BorderPane
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

        angleSlider.setOrientation(Orientation.VERTICAL);
        angleSlider.setMin(0);
        angleSlider.setMax(180);
        angleSlider.setMajorTickUnit(180);
        angleSlider.setMinorTickCount(0);
        angleSlider.setBlockIncrement(1);
        velocitySlider.setShowTickLabels(true);

        // aligning and filling the controlGrid
        controlGrid.setGridLinesVisible(true);
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(100);
        controlGrid.getColumnConstraints().addAll(column1, column2);
        RowConstraints row1 = new RowConstraints(50);
        RowConstraints row2 = new RowConstraints(350);
        RowConstraints row3 = new RowConstraints(50);
        RowConstraints row4 = new RowConstraints(50);
        controlGrid.getRowConstraints().addAll(row1, row2, row3, row4);
        controlGrid.add(velocityLabel,0,0);
        controlGrid.setHalignment(velocityLabel, HPos.CENTER);
        controlGrid.add(angleLabel,1,0);
        controlGrid.setHalignment(angleLabel, HPos.CENTER);
        controlGrid.add(velocitySlider,0,1);
        controlGrid.setHalignment(velocitySlider, HPos.CENTER);
        controlGrid.add(angleSlider,1,1);
        controlGrid.setHalignment(angleSlider, HPos.CENTER);



        // now we fill the BorderPane and align it
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setTop(topBox);
        this.setCenter(gameGrid);
        this.setRight(controlGrid);
        this.setBottom(bottomLabel);


    }
    // implementatie van de nodige
    // package-private Getters

}
