package AngryTanks.view.game;

import AngryTanks.model.AngryTanksModel;
import AngryTanks.model.Landscape;
import AngryTanks.model.Player;
import AngryTanks.view.end.EndPresenter;
import AngryTanks.view.end.EndView;
import AngryTanks.view.settings2.Settings2Presenter;
import AngryTanks.view.settings2.Settings2View;
import AngryTanks.view.start.StartView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class GamePresenter {
    private AngryTanksModel model;
    private GameView view;
    private StartView startView;
    private MediaPlayer fireSoundPlayer;
    private EndView endView;
    private EndPresenter endPresenter;
    private Settings2View settingsView;
    private Settings2Presenter settingsPresenter;
    private double fireSoundVolume = 0.5;

    public GamePresenter(AngryTanksModel model, GameView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
        this.fireSoundVolume = model.getVolume();
    }

    private void addEventHandlers() {
        view.getPlayer1Label().setText(model.getPlayerNames().get(0));
        view.getPlayer2Label().setText(model.getPlayerNames().get(1));
        view.getFireButton().setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // geluid laden en afspelen met playFireSound()
                String soundPath = getClass().getResource("/tank_firing.mp3").toExternalForm();
                Media fireSound = new Media(soundPath);
                fireSoundPlayer = new MediaPlayer(fireSound);
                fireSoundPlayer.setVolume(fireSoundVolume);
                fireSoundPlayer.play();
                boolean endGame = model.nextTurn(view.getAngleSlider().getValue(), view.getVelocitySlider().getValue());
                Player player1 = model.getPlayers().get(0);
                Player player2 = model.getPlayers().get(1);
                view.getHealthBox1().getChildren().removeAll(view.getHealthBox1().getChildren());
                view.getHealthBox2().getChildren().removeAll(view.getHealthBox2().getChildren());
                for (int i = 0; i < player1.getTank().getLives(); i++) {
                    view.getHealthBox1().getChildren().add(new Circle(15, Color.GREEN));
                }
                for (int i = 0; i < player2.getTank().getLives(); i++) {
                    view.getHealthBox2().getChildren().add(new Circle(15, Color.GREEN));
                }
                StringBuilder sb = new StringBuilder("Previous turn: vel=");
                sb.append(Math.round(model.getHistory().getShots().getLast().getVelocity()));
                sb.append(" ang=");
                sb.append(Math.round(model.getHistory().getShots().getLast().getAngle() * 180 / Math.PI));
                sb.append(" wind=");
                sb.append(Math.round(model.getHistory().getWinds().getLast().getPower()));
                sb.append(" dir=");
                sb.append(model.getHistory().getWinds().getLast().getDirection());
                sb.append(" imp=");
                sb.append(model.getHistory().getTrajectories().getLast().getImpactType());
                if (model.getActivePlayer() == player2) {
                    view.getPreviousTurn1().setText(sb.toString());
                } else if (model.getActivePlayer() == player1) {
                    view.getPreviousTurn2().setText(sb.toString());
                }
                updateView();
                if (endGame) {
                    endView = new EndView();
                    endPresenter = new EndPresenter(model, endView);
                    // huidige stage (scherm) ophalen
                    Stage stage = new Stage();
                    // nieuwe scene op de stage zetten
                    stage.setScene(new Scene(endView));
                    endView.setPrefSize(1300, 800);
                    stage.sizeToScene();
                    stage.setTitle("End Screen");
                    Timeline timeline = new Timeline(
                            new KeyFrame(Duration.seconds(5), e -> {
                                // Dit wordt uitgevoerd na 5 seconden
                                stage.show();
                            })
                    );
                    timeline.setCycleCount(1);
                    timeline.play();
                }
            }
        });
        view.getSettingsButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                settingsView = new Settings2View();
                settingsPresenter = new Settings2Presenter(model, settingsView, view, GamePresenter.this);
                Stage stage = (Stage) view.getScene().getWindow();
                stage.setScene(new Scene(settingsView));
                settingsView.setPrefSize(1300, 800);
                stage.sizeToScene();
                stage.setTitle("Settings Screen");
                stage.show();
            }
        });
    }

    private void updateView() {
        // Vult de view met data uit model
        view.getWindLabel().setText(model.getWind().toString());
        for (int col = 0; col < model.getLandscape().getTerrain().length; col++) {
            for (int row = 0; row < model.getLandscape().getTerrain()[col].length; row++) {
                char ch = model.getLandscape().getTerrain()[col][row];
                Rectangle rect = new Rectangle(5, 5);
                switch (ch) {
                    case '-' -> rect.setFill(Color.DARKGRAY);
                    case '.' -> rect.setFill(Color.DARKGREEN);
                    case '#' -> rect.setFill(Color.LIGHTBLUE);
                    case '/', 'Z' -> rect.setFill(Color.YELLOW);
                    case 'X', 'Y' -> rect.setFill(Color.BLACK);
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
                ButtonType ja = new ButtonType("Ja");
                alert.getButtonTypes().addAll(nee, ja);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(nee)) {
                    event.consume();
                }
            }
        });
    }

    public void setFireSoundVolume(double v) {
        this.fireSoundVolume = v;
        if (fireSoundPlayer != null) {
            fireSoundPlayer.setVolume(v);
        }
    }

    public double getFireSoundVolume() {
        return fireSoundVolume;
    }
}
