package AngryTanks.view.start;

import AngryTanks.model.AngryTanksModel;
import AngryTanks.model.Landscape;
import AngryTanks.view.game.GamePresenter;
import AngryTanks.view.game.GameView;
import AngryTanks.view.settings.SettingsPresenter;
import AngryTanks.view.settings.SettingsView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartPresenter {
    private AngryTanksModel model;
    private StartView view;
    private GameView gameView;
    private GamePresenter gamePresenter;
    private SettingsView settingsView;
    private SettingsPresenter settingsPresenter;

    public StartPresenter(AngryTanksModel model, StartView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {
        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
        view.getPlayButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.getPlayerNames().add(view.getName1().getText());
                model.getPlayerNames().add(view.getName2().getText());
                model.addPlayers();
                // gameview en presenter aanmaken
                gameView = new GameView();
                gamePresenter = new GamePresenter(model, gameView);
                // huidige stage (scherm) ophalen
                Stage stage = (Stage) view.getScene().getWindow();
                // nieuwe scene op de stage zetten
                stage.setScene(new Scene(gameView));
                gameView.setPrefSize(1300, 800);
                stage.sizeToScene();
                stage.setTitle("Game Screen");
                stage.show();
            }
        });
        view.getName1().setOnInputMethodTextChanged(new EventHandler<InputEvent>() {
            @Override
            public void handle(InputEvent inputEvent) {
                model.getPlayers().getFirst().setName(view.getName1().getText());
            }
        });
        view.getName2().setOnInputMethodTextChanged(new EventHandler<InputEvent>() {
            @Override
            public void handle(InputEvent inputEvent) {
                model.getPlayers().getLast().setName(view.getName2().getText());
            }
        });
        view.getSettingsButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                settingsView = new SettingsView();
                settingsPresenter = new SettingsPresenter(model, settingsView, view);
                Stage stage = (Stage) view.getScene().getWindow();
                stage.setScene(new Scene(settingsView));
                settingsView.setPrefSize(1300, 800);
                stage.sizeToScene();
                stage.setResizable(true);
                settingsView.getScene().getWindow().sizeToScene();
                stage.setTitle("Settings Screen");
                stage.show();
            }
        });

    }
    private void updateView() {
        // Vult de view met data uit model
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
                ButtonType ja =  new ButtonType("Ja");
                alert.getButtonTypes().addAll(nee, ja);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(nee)){
                    event.consume();
                }
            }
        });
    }
}
