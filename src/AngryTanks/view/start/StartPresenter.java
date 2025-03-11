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
import javafx.stage.Stage;

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
                Landscape terrainModel = new Landscape();
                int width = terrainModel.getTerrain()[0].length;
                int height = terrainModel.getTerrain().length;
                // gameview en presenter aanmaken
                gameView = new GameView(width, height);
                gamePresenter = new GamePresenter(model, gameView);
                // huidige stage (scherm) ophalen
                Stage stage = (Stage) view.getScene().getWindow();
                // nieuwe scene op de stage zetten
                stage.setScene(new Scene(gameView));
                gameView.getScene().getWindow().sizeToScene();
                stage.setTitle("Game Screen");
                stage.show();
            }
        });
        view.getSettingsButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                settingsView = new SettingsView();
                settingsPresenter = new SettingsPresenter(model, settingsView, view);
                Stage stage = (Stage) view.getScene().getWindow();
                stage.setScene(new Scene(settingsView));
                stage.sizeToScene();
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
    }
}
