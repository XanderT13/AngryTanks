package AngryTanks.view.settings2;

import AngryTanks.model.AngryTanksModel;
import AngryTanks.view.game.GamePresenter;
import AngryTanks.view.game.GameView;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
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
        this.addEventHandlers();
        this.updateView();
        this.gamePresenter = gamePresenter;
    }

    private void addEventHandlers() {
        view.getVolumeSlider().setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Haal de waarde van de slider op en pas het volume aan
                double newVolume = view.getVolumeSlider().getValue();
                model.setVolume(newVolume);
                gamePresenter.setFireSoundVolume(newVolume);
            }
        });
        view.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameView newGameView = new GameView();
                GamePresenter gamePresenter1 = new GamePresenter(model, newGameView);
                Stage stage = (Stage) view.getScene().getWindow();
                stage.setScene(new Scene(newGameView));
                newGameView.setPrefSize(1300,800);
                stage.sizeToScene();
                stage.setResizable(true);
                stage.setTitle("Start Screen");
                stage.show();
            }
        });
    }

    private void updateView() {
        view.getVolumeSlider().setValue(model.getVolume());

    }

    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
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
