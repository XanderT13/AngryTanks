package AngryTanks;


import AngryTanks.model.AngryTanksModel;
import AngryTanks.view.start.StartPresenter;
import AngryTanks.view.start.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        AngryTanksModel model = new AngryTanksModel();
        StartView view = new StartView();
        view.setPrefSize(1300,800);
        StartPresenter presenter = new StartPresenter(model, view);
        primaryStage.setTitle("Angry Tanks Start Screen");
        primaryStage.setScene(new Scene(view));
        primaryStage.setResizable(true);
        primaryStage.sizeToScene();
        presenter.addWindowEventHandlers();
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}