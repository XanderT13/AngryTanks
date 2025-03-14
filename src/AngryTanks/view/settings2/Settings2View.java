package AngryTanks.view.settings2;

import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

public class Settings2View extends BorderPane {
    private Slider volumeSlider;

    public Settings2View() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        volumeSlider = new Slider();
    }

    private void layoutNodes() {
        volumeSlider.setMin(0.0);
        volumeSlider.setMax(1.0);
        volumeSlider.setValue(0.5);
        volumeSlider.setShowTickLabels(true);
        volumeSlider.setShowTickMarks(true);
        volumeSlider.setMajorTickUnit(0.01);
        volumeSlider.setMinorTickCount(0);

        this.setCenter(volumeSlider);
    }
}

