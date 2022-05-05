package gruppe8.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

    Stage stage;
    LogInScreen logInScreen;
    LeaderOptions leadOptions;
    VolunteerSchedule volunSchedule;
    //HandleVolunteer hndlVolun;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Frivillig på Roskilde");
        stage = primaryStage;

        logInScreen = new LogInScreen(this);
        Scene frontLogIn = new Scene(logInScreen, 800, 600);
        primaryStage.setScene(frontLogIn);
        primaryStage.show();

    }

    public void moveToLeaderOptions() {
        leadOptions = new LeaderOptions(this);
        Scene leadOption = new Scene(leadOptions, 800,600);
        stage.setScene(leadOption);
    }

    public void moveToVolunteerSchedule() {
        volunSchedule = new VolunteerSchedule(this);
        Scene schedule = new Scene(volunSchedule, 800, 600);
        stage.setScene(schedule);
    }
}