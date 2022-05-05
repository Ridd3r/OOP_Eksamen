package gruppe8.gui;

import javafx.geometry.Insets;
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
import static gruppe8.backend.Frivillig.*;

//Opret Frivillig
public class CreateVolunteer extends BorderPane {

    GUI main;

    public CreateVolunteer(GUI main){
        this.main = main;
        setTop(VBoxTop());
        setCenter(createVolunteer());
        setBottom(HBoxBottom());
    }

    VBox createVolunteer() {
        VBox vBox = new VBox(10);
        Label firstName = new Label("Fornavn: ", new TextField("Indtast dit fornavn"));
        firstName.setContentDisplay(ContentDisplay.RIGHT);
        firstName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Label lastName = new Label("Efternavn: ", new TextField("Indtast dit efternavn"));
        lastName.setContentDisplay(ContentDisplay.RIGHT);
        lastName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Label age = new Label("Alder: ", new TextField("Indtast din alder"));
        age.setContentDisplay(ContentDisplay.RIGHT);
        age.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Label telephone = new Label("Telefon: ", new TextField("Indtast dit telefonnummer"));
        telephone.setContentDisplay(ContentDisplay.RIGHT);
        telephone.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Label email = new Label("Email: ", new TextField("Indtast din email"));
        email.setContentDisplay(ContentDisplay.RIGHT);
        email.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));

        HBox buttons = new HBox(20);
        Button opret = new Button("Opret Frivillig");
        opret.setOnAction(e -> main.moveToVolunteerList());
        HBox.setHgrow(opret, Priority.ALWAYS);
        buttons.setAlignment(Pos.CENTER);
        buttons.getChildren().add(opret);

        vBox.setPadding(new Insets(25, 25, 25, 25));
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(firstName, lastName, age, telephone, email, buttons);
        return vBox;
    }
}
