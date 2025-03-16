package AngryTanks.view.end;

import AngryTanks.model.AngryTanksModel;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class EndView extends GridPane {
    // private Node attributen (controls)
    private Label winnerLabel;
    private ImageView endImage;
    private Label amountTurnsLabel;
    private Label accuracyLabel;

    public EndView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // Initialisatie van de Nodes
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
        winnerLabel = new Label();
        amountTurnsLabel = new Label();
        accuracyLabel = new Label();
        endImage = new ImageView();
    }

    private void layoutNodes() {
        this.getStylesheets().add("/style.css");
        this.getStyleClass().add("end-view");
        this.setAlignment(Pos.CENTER);

        winnerLabel.getStyleClass().add("winnaarlabel");
        this.add(winnerLabel, 0, 0);
        amountTurnsLabel.getStyleClass().add("winnaarlabel");
        this.add(amountTurnsLabel, 0, 1);
        accuracyLabel.getStyleClass().add("winnaarlabel");
        this.add(accuracyLabel, 0, 2);
    }
    // implementatie van de nodige
    // package-private Getters

    public Label getWinnerLabel() {
        return winnerLabel;
    }

    public Label getAmountTurnsLabel() {
        return amountTurnsLabel;
    }

    public Label getAccuracyLabel() {
        return accuracyLabel;
    }
}
