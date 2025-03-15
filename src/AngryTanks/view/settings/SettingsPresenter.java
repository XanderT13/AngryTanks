package AngryTanks.view.settings;

import AngryTanks.model.AngryTanksModel;
import AngryTanks.view.game.GameView;
import AngryTanks.view.start.StartPresenter;
import AngryTanks.view.start.StartView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SettingsPresenter {
    private AngryTanksModel model;
    private SettingsView view;
    private StartView startView;


    public SettingsPresenter(AngryTanksModel model, SettingsView view, StartView startView) {
        this.model = model;
        this.view = view;
        this.startView = startView;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                StartView newStartview = new StartView();
                StartPresenter startPresenter = new StartPresenter(model, newStartview);
                Stage stage = (Stage) view.getScene().getWindow();
                stage.setScene(new Scene(newStartview));
                newStartview.setPrefSize(1300, 800);
                stage.sizeToScene();
                stage.setTitle("Start Screen");
                stage.show();
            }
        });
        view.getDifficultySlider().setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                model.setDifficulty((int) view.getDifficultySlider().getValue());
            }
        });
    }

    private void updateView() {

    }

    public void addWindowEventHandlers() {
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
