package AngryTanks.view.end;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;



public class EndView extends BorderPane {
    // private Node attributen (controls)
    private Label winnaarLabel;
    private ImageView endImage;

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
        endImage = new ImageView();
    }
    private void layoutNodes() {
        this.getStylesheets().add("/style.css");
        this.getStyleClass().add("end-view");

        this.setCenter(winnaarLabel);
    }
    // implementatie van de nodige
    // package-private Getters
}
