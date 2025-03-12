package AngryTanks.view.settings;

import AngryTanks.model.AngryTanksModel;
import AngryTanks.view.game.GameView;
import AngryTanks.view.start.StartPresenter;
import AngryTanks.view.start.StartView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
               stage.setWidth(1200);
               stage.setHeight(800);
               stage.setTitle("Start Screen");
               stage.show();
             }
        });
    }

    private void updateView() {

    }
}
