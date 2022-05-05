package gruppe8.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static gruppe8.gui.BackgroundPane.*;

public class CreateStall extends BorderPane {

    GUI main;

    public CreateStall (GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(createStall());
        setBottom(HBoxBottom());
    }

    VBox createStall() {
        VBox stalls = new VBox();
        stalls.setAlignment(Pos.CENTER);
        Label stallName = new Label("Bodens Navn: ", new TextField("Indtast navnet på din bod"));
        stallName.setContentDisplay(ContentDisplay.RIGHT);
        stallName.setAlignment(Pos.CENTER_LEFT);
        stallName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));

        HBox button = new HBox(20);
        HBox.setHgrow(button, Priority.ALWAYS);
        button.setAlignment(Pos.BOTTOM_CENTER);
        Button createStallButton = new Button("Opret en bod");
        createStallButton.setAlignment(Pos.BOTTOM_CENTER);
        createStallButton.setOnAction(e -> main.moveToStallsList());
        button.getChildren().add(createStallButton);

        stalls.getChildren().addAll(stallName, button);
        return stalls;
    }
}
