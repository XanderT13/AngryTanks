package AngryTanks.view.settings;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class SettingsView extends GridPane {
    private Button backButton;
    private ImageView settingsImage;
    private Slider difficultySlider;
    private Slider windSlider;

    public SettingsView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        backButton = new Button("Back");

        settingsImage = new ImageView();

        difficultySlider = new Slider();
        windSlider = new Slider();
    }

    private void layoutNodes() {
        this.getStylesheets().add("/style.css");
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(false);
        this.getStyleClass().add("settings-view");
        ColumnConstraints column1 = new ColumnConstraints(600);
        ColumnConstraints column2 = new ColumnConstraints(600);
        this.getColumnConstraints().addAll(column1, column2);
        RowConstraints row1 = new RowConstraints(200);
        RowConstraints row2 = new RowConstraints(200);
        RowConstraints row3 = new RowConstraints(200);
        RowConstraints row4 = new RowConstraints(100);
        this.getRowConstraints().addAll(row1, row2, row3,row4);

        backButton.setPrefSize(75, 75);
        backButton.setOnMouseEntered(e -> backButton.setStyle(
                "-fx-border-color: Black;" +
                        "-fx-border-width: 2;"
        ));
        this.add(backButton, 1, 3);
        this.setHalignment(backButton, HPos.RIGHT);
        this.setMargin(backButton, new Insets(0,40,0,0));

        difficultySlider.getStyleClass().add("tankslider");
        difficultySlider.setMaxWidth(400);;
        difficultySlider.setMin(1);
        difficultySlider.setMax(5);
        difficultySlider.setShowTickLabels(true);
        difficultySlider.setShowTickMarks(true);
        difficultySlider.setMajorTickUnit(1);
        difficultySlider.setMinorTickCount(0);
        difficultySlider.setBlockIncrement(1);
        difficultySlider.setSnapToTicks(true);
        this.add(difficultySlider, 0, 2);
        this.setHalignment(difficultySlider, HPos.CENTER);

        windSlider.getStyleClass().add("tankslider");
        windSlider.setMaxWidth(400);;
        windSlider.setMin(1);
        windSlider.setMax(5);
        windSlider.setShowTickLabels(true);
        windSlider.setShowTickMarks(true);
        windSlider.setMajorTickUnit(1);
        windSlider.setMinorTickCount(0);
        windSlider.setBlockIncrement(1);
        windSlider.setSnapToTicks(true);
        this.add(windSlider, 1, 2);
        this.setHalignment(windSlider, HPos.CENTER);

    }

    Button getBackButton() {
        return backButton;
    }
}
