package AngryTanks.view.game;

import AngryTanks.model.AngryTanksModel;
import AngryTanks.model.Landscape;
import AngryTanks.view.start.StartView;

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
        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
    }
    private void updateView() {
        // Vult de view met data uit model
        view.drawTerrain(model.getLandscape().getTerrain());
    }
    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }
}
