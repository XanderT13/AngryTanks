package AngryTanks.view.settings;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

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
        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(true);
        this.getStyleClass().add("settings");
        this.setPrefSize(1200, 750);

        backButton.setPrefSize(75, 75);
        backButton.setOnMouseEntered(e -> backButton.setStyle(
                "-fx-border-color: Black;" +
                        "-fx-border-width: 2;"
        ));
        this.add(backButton, 0, 0);

    }

    Button getBackButton() {
        return backButton;
    }
}
