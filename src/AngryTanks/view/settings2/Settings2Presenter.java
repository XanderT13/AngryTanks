package AngryTanks.view.settings2;

import AngryTanks.model.AngryTanksModel;
import AngryTanks.view.game.GamePresenter;
import AngryTanks.view.game.GameView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Settings2Presenter {
    private AngryTanksModel model;
    private Settings2View view;
    private GameView gameView;
    private GamePresenter gamePresenter;

    public Settings2Presenter(AngryTanksModel model, Settings2View view, GameView gameView, GamePresenter gamePresenter) {
        this.model = model;
        this.view = view;
        this.gameView = gameView;
        this.gamePresenter = gamePresenter;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        // Event handler voor de volume slider
        view.getVolumeSlider().setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Haal de waarde van de slider op en pas het volume aan
                double newVolume = view.getVolumeSlider().getValue();
                // Pas het volume aan in het model
                model.setVolume(newVolume);
                // Werk het volume bij in de game-presenter
                gamePresenter.setFireSoundVolume(newVolume);
            }
        });

        // Event handler voor de back button
        view.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Zet de game terug naar het startscherm
                GameView newGameView = new GameView();
                GamePresenter gamePresenter1 = new GamePresenter(model, newGameView);
                Stage stage = (Stage) view.getScene().getWindow();
                stage.setScene(new Scene(newGameView));
                newGameView.setPrefSize(1260, 700);
                stage.sizeToScene();
                stage.setResizable(true);
                stage.setTitle("Game Screen");
                stage.show();
            }
        });
    }

    private void updateView() {
        // Update de volume slider met de waarde uit het model
        view.getVolumeSlider().setValue(model.getVolume());
    }

    public void addWindowEventHandlers() {
        // Event handler voor het sluiten van het venster
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Hierdoor stopt het spel!");
                alert.setTitle("Opgelet!");
                alert.setContentText("Ben je zeker?");
                alert.getButtonTypes().clear();
                ButtonType nee = new ButtonType("Nee");
                ButtonType ja = new ButtonType("Ja");
                alert.getButtonTypes().addAll(nee, ja);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(nee)) {
                    event.consume();
                }
            }
        });
    }
}
