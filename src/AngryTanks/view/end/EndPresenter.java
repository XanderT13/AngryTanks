package AngryTanks.view.end;

import AngryTanks.model.AngryTanksModel;
import AngryTanks.model.ImpactType;
import AngryTanks.model.Trajectory;

import static AngryTanks.model.ImpactType.BLAST;
import static AngryTanks.model.ImpactType.HIT;

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
        view.getWinnerLabel().setText(model.getActivePlayer().getName() + " has won!");
        view.getAmountTurnsLabel().setText("Amount of turns: " + model.getHistory().getTrajectories().size());
        int hits = 0;
        int turns = 0;
        for (int i = 0; i < model.getHistory().getTrajectories().size(); i++) {
            ImpactType impactType = model.getHistory().getTrajectories().get(i).getImpactType();
            if (impactType == HIT || impactType == BLAST) {
                hits++;
            }
            if (model.getHistory().getActivePlayers().get(i) == model.getActivePlayer()) {
                turns++;
            }
        }
        double accuracy = (double) hits / (double) turns;
        view.getAccuracyLabel().setText(String.format("Accuracy: %.0f", accuracy * 100) + "%");

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
    }

    private void updateView() {
        // Vult de view met data uit model
    }

    public void addWindowEventHandlers() {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }
}
