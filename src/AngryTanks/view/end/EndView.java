package AngryTanks.view.end;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;



public class EndView extends BorderPane {
    // private Node attributen (controls)
    private Label winnaarLabel;

    public EndView() {
        this.initialiseNodes();
        this.layoutNodes();
    }
    private void initialiseNodes() {
        // Initialisatie van de Nodes
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
        winnaarLabel = new Label();
    }
    private void layoutNodes() {
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
        this.setCenter(winnaarLabel);
    }
    // implementatie van de nodige
    // package-private Getters

    public Label getWinnaarLabel() {
        return winnaarLabel;
    }
}
