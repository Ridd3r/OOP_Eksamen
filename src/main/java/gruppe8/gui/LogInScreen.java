package gruppe8.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static gruppe8.gui.BackgroundPane.*;

//Primær Login Side
public class LogInScreen extends BorderPane {

    GUI main;

    public LogInScreen(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(logInGrid());
        setBottom(HBoxBottom());
    }

    GridPane logInGrid() {
        GridPane logInGrid = new GridPane();
        logInGrid.setAlignment(Pos.CENTER);
        logInGrid.setVgap(5);

        //For loop to resize columns constantly if window is resized
        //i < 10 because there is 10 columns defined in the grid
        for (int i = 0; i < 10; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setHgrow(Priority.ALWAYS);
            logInGrid.getColumnConstraints().add(cc);
        }

        //For loop to resize rows constantly if window is resized
        //j < 10 because there is 10 rows defined in the grid
        for (int i = 0; i < 10; i++) {
            RowConstraints rc = new RowConstraints();
            rc.setVgrow(Priority.ALWAYS);
            logInGrid.getRowConstraints().add(rc);
        }

        Label welcome = new Label("Log venligst ind");
        welcome.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        welcome.setAlignment(Pos.CENTER);
        logInGrid.add(welcome, 5, 0, 1, 1);

        Label username = new Label("Brugernavn: ", new TextField());
        username.setContentDisplay(ContentDisplay.RIGHT);
        username.setGraphicTextGap(10);
        username.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        logInGrid.add(username, 4,1, 2, 1);

        Label password = new Label("Password: ", new TextField());
        password.setContentDisplay(ContentDisplay.RIGHT);
        password.setGraphicTextGap(24);
        password.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        logInGrid.add(password, 4, 2, 2 ,1);

        Button logInVolunteer = new Button("Log ind som Frivillig");
        logInGrid.add(logInVolunteer, 3, 3, 2, 1);
        logInVolunteer.setAlignment(Pos.CENTER_LEFT);
        logInVolunteer.setOnAction(e -> main.moveToVolunteerSchedule());

        Button logInLeader = new Button("Log ind som Ansvarlig");
        logInGrid.add(logInLeader, 6, 3, 2, 1);
        logInLeader.setAlignment(Pos.CENTER_RIGHT);
        logInLeader.setOnAction(e -> main.moveToLeaderOptions());

        return logInGrid;
    }
}
