package AngryTanks.view.settings2;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class Settings2View extends BorderPane {
    private Slider volumeSlider;
    private Button backButton;
    private ImageView settingsScreen;

    public Settings2View() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        volumeSlider = new Slider();
        backButton = new Button("Back");
        settingsScreen = new ImageView();
    }

    private void layoutNodes() {
        this.getStylesheets().add("/style.css");
        this.getStyleClass().add("settings2-view");
        volumeSlider.setMin(0.0);
        volumeSlider.setMax(1.0);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setMajorTickUnit(0.1);
        volumeSlider.setMinorTickCount(0);
        volumeSlider.setMaxWidth(700);
        volumeSlider.getStyleClass().add("tankslider");

        backButton.setPrefSize(75, 75);
        backButton.setOnMouseEntered(e -> backButton.setStyle(
                "-fx-border-color: Black;" +
                        "-fx-border-width: 2;"
        ));

        this.setCenter(volumeSlider);
        this.setBottom(backButton);
    }

    Slider getVolumeSlider() {
        return volumeSlider;
    }

    Button getBackButton() {
        return backButton;
    }
}

