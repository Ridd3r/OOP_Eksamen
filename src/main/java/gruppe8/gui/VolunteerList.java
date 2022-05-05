package gruppe8.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static gruppe8.gui.BackgroundPane.*;

public class VolunteerList extends BorderPane {

    GUI main;

    public VolunteerList(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(volunteerListView());
        setBottom(HBoxBottom());
    }

    VBox volunteerListView() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        ListView volunteerList = new ListView();

        volunteerList.getItems().add("Test 1");
        volunteerList.getItems().add("Test 2");
        volunteerList.getItems().add("Test 3");

        hBox.getChildren().add(volunteerList);

        Button opretFrivillig = new Button("Opret en Frivillig");
        opretFrivillig.setAlignment(Pos.BOTTOM_CENTER);
        opretFrivillig.setOnAction(e -> main.moveToCreateVolunteer());

        Button tilbage = new Button("Tilbage Debugger");
        tilbage.setAlignment(Pos.BOTTOM_CENTER);
        tilbage.setOnAction(e -> main.moveToLogInScreen());

        vBox.getChildren().addAll(hBox, opretFrivillig, tilbage);
        return vBox;
    }

}
