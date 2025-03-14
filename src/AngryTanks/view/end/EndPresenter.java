package AngryTanks.view.end;

import AngryTanks.model.AngryTanksModel;

public class EndPresenter {
    private AngryTanksModel model;
    private EndView view;

    public EndPresenter(
            AngryTanksModel model,
            EndView view) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }
    private void addEventHandlers() {
        view.getWinnaarLabel().setText(model.getActivePlayer().getName() + "has won!");
        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
    }
    private void updateView() {
        // Vult de view met data uit model
    }
    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }
}
