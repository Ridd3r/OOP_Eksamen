package gruppe8.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.spreadsheet.Grid;

import static gruppe8.gui.BackgroundPane.*;

public class StallsList extends BorderPane {

    GUI main;

    public StallsList(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(stallsListView());
        setBottom(HBoxBottom());
    }

    VBox stallsListView() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        ListView stallsList = new ListView();

        stallsList.getItems().add("Stall 1");
        stallsList.getItems().add("Stall 2");
        stallsList.getItems().add("Stall 3");

        hBox.getChildren().add(stallsList);

        Button opretStall = new Button("Opret en Bod");
        opretStall.setAlignment(Pos.BOTTOM_LEFT);
        opretStall.setOnAction(e -> main.moveToCreateStall());

        Button chooseStall = new Button("Vælg Bod");
        chooseStall.setAlignment(Pos.BOTTOM_RIGHT);
        chooseStall.setOnAction(e -> main.moveToStallSchedule());

        vBox.getChildren().addAll(hBox, chooseStall, opretStall);
        return vBox;
    }
}
