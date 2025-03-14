package AngryTanks.view.game;

import AngryTanks.model.AngryTanksModel;
import AngryTanks.model.Landscape;
import AngryTanks.view.start.StartView;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.WindowEvent;

public class GamePresenter {
    private AngryTanksModel model;
    private GameView view;
    private StartView startView;
    private MediaPlayer fireSoundPlayer;

    public GamePresenter(AngryTanksModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        view.getFireButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // geluid laden en afspelen met playFireSound()
                String soundPath = getClass().getResource("/tank_firing.mp3").toExternalForm();
                Media fireSound = new Media(soundPath);
                fireSoundPlayer = new MediaPlayer(fireSound);
                fireSoundPlayer.setVolume(1.0);
                fireSoundPlayer.play();

                model.nextTurn(view.getAngleSlider().getValue(),view.getVelocitySlider().getValue());
                updateView();
            }
        });
    }

    private void updateView() {
        // Vult de view met data uit model
        view.getWindLabel().setText(model.getWind().toString());
        view.getBottomLabel().setText(model.getActivePlayer().playTurn(model.getWind(), view.getAngleSlider().getValue(),view.getVelocitySlider().getValue()).toString());
        //view.drawTerrain(model.getLandscape().getTerrain());
        for (int col = 0; col < model.getLandscape().getTerrain().length; col++) {
            for (int row = 0; row < model.getLandscape().getTerrain()[col].length;row++) {
                char ch = model.getLandscape().getTerrain()[col][row];
                Rectangle rect = new Rectangle(5, 5);
                switch(ch){
                 case '-' -> rect.setFill(Color.DARKGRAY);
                 case '.' -> rect.setFill(Color.DARKGREEN);
                 case '#' -> rect.setFill(Color.LIGHTBLUE);
                 case '/', 'Z' -> rect.setFill(Color.YELLOW);
                 case 'X','Y' -> rect.setFill(Color.BLACK);
                 case 'A' -> rect.setFill(Color.RED);
                 default -> rect.setFill(Color.WHITE);
                }
                view.getGameGrid().add(rect, row, col);
            }
        }
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
