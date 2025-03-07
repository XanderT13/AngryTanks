package AngryTanks;


import AngryTanks.model.AngryTanksModel;
import AngryTanks.view.start.StartPresenter;
import AngryTanks.view.start.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        AngryTanksModel model =
                new AngryTanksModel(2);
        StartView view =
                new StartView();
        StartPresenter presenter =
                new StartPresenter(model, view);
        primaryStage.setTitle("Angry Tanks Start Screen");
        primaryStage.setWidth(1200);
        primaryStage.setHeight(750);
        primaryStage.setScene(new Scene(view));
        presenter.addWindowEventHandlers();
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}