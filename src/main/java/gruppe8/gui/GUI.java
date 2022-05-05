package gruppe8.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI extends Application {

    Stage stage;
    LogInScreen logInScreen;
    LeaderOptions leaderOptions;
    VolunteerSchedule volunteerSchedule;
    CreateVolunteer createVolunteer;
    VolunteerList volunteerList;
    StallsList stallsList;
    CreateStall createStall;
    StallSchedule stallSchedule;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Frivillig på Roskilde");
        stage = primaryStage;

        logInScreen = new LogInScreen(this);
        Scene frontLogIn = new Scene(logInScreen, 800, 600);
        primaryStage.setScene(frontLogIn);
        primaryStage.show();
    }

    public void moveToLogInScreen() { //Har ikke fundet en løsning til at få log ud til at virke på tværs af scenes fra MenuBar
        logInScreen = new LogInScreen(this); //Skaber en ny variabel til skift
        Scene frontLogIn = new Scene(logInScreen, 800, 600); //Skaber scenen fra variablen
        stage.setScene(frontLogIn); //Sætter scenen til den valgte
    }

    public void moveToLeaderOptions() { //Skift til Ansvarlig
        leaderOptions = new LeaderOptions(this);
        Scene leaderOption = new Scene(leaderOptions, 800,600);
        stage.setScene(leaderOption);
    }

    public void moveToVolunteerSchedule() { //Skift til Frivillig Skema
        volunteerSchedule = new VolunteerSchedule(this);
        Scene schedule = new Scene(volunteerSchedule, 800, 600);
        stage.setScene(schedule);
    }

    public void moveToCreateVolunteer() {
        createVolunteer = new CreateVolunteer(this);
        Scene createVolunteers = new Scene(createVolunteer, 800, 600);
        stage.setScene(createVolunteers);
    }

    public void moveToVolunteerList() {
        volunteerList = new VolunteerList(this);
        Scene volunteerLists = new Scene(volunteerList, 800, 600);
        stage.setScene(volunteerLists);
    }

    public void moveToStallsList() {
        stallsList = new StallsList(this);
        Scene stallsLists = new Scene(stallsList, 800, 600);
        stage.setScene(stallsLists);
    }

    public void moveToCreateStall() {
        createStall = new CreateStall(this);
        Scene createStalls = new Scene(createStall, 800, 600);
        stage.setScene(createStalls);
    }

    public void moveToStallSchedule() {
        stallSchedule = new StallSchedule(this);
        Scene stallSchedules = new Scene(stallSchedule, 800,600);
        stage.setScene(stallSchedules);
    }
}