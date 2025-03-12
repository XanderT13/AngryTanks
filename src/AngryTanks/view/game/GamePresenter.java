package AngryTanks.view.game;

import AngryTanks.model.AngryTanksModel;
import AngryTanks.model.Landscape;
import AngryTanks.view.start.StartView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GamePresenter {
    private AngryTanksModel model;
    private GameView view;
    private StartView startView;

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
                model.nextTurn(view.getAngleSlider().getValue(),view.getVelocitySlider().getValue());
                updateView();
            }
        });
        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
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
                 case '/' -> rect.setFill(Color.YELLOW);
                 case 'X' -> rect.setFill(Color.BLACK);
                 default -> rect.setFill(Color.WHITE);
                }
                view.getGameGrid().add(rect, row, col);
            }
        }
    }

    public void addWindowEventHandlers() {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }
}
