package gruppe8.gui;

import gruppe8.backend.DataHandlerBod;
import gruppe8.backend.DataHandlerFrivillig;
import gruppe8.backend.Frivillig;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import static gruppe8.gui.BackgroundPane.*;

//Individuel Frivillig Vagtplan
public class VolunteerSchedule extends BorderPane {

    GUI main;

    public VolunteerSchedule(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(volunteerSchedule());
        setBottom(HBoxBottom());
        setBackground(Background());
    }

    VBox volunteerSchedule() {
        VBox volunteerScheduleVBox = new VBox();
        volunteerScheduleVBox.setAlignment(Pos.CENTER);
        volunteerScheduleVBox.setSpacing(30);
        HBox stallScheduleHBox = new HBox();
        stallScheduleHBox.setAlignment(Pos.CENTER);

        DataHandlerFrivillig getFrivilligHandler = new DataHandlerFrivillig();
        DataHandlerBod getVagter = new DataHandlerBod();
        getFrivilligHandler.openFile();
        getVagter.openFile();

        System.out.println(getFrivilligHandler.tempId);

        Frivillig s = getFrivilligHandler.getFrivillig(2);

        HBox top = new HBox();
        Text schedule = new Text(s.getFirstName() + " " + s.getLastName() +"'s Vagtplan");
        top.setAlignment(Pos.TOP_CENTER);
        schedule.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        top.getChildren().add(schedule);

        HBox first = new HBox();
        first.setAlignment(Pos.CENTER);
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        Label eightToTwelve = new Label("08 - 12");
        Label twelveToFour = new Label("12 - 16");
        Label fourToEight = new Label("16 - 20");
        Label monday = new Label("Mandag");
        Label tuesday = new Label("Tirsdag");
        Label wednesday = new Label("Onsdag");
        Label thursday = new Label("Torsdag");
        Label friday = new Label("Fredag");
        Label saturday = new Label("Lørdag");
        Label sunday = new Label("Søndag");
        Label mandagMorgen = new Label(getVagter.getVagt(s.getID(), 0)); //Funktionskald til getVagt skriv vagtNr manuelt - hent frivilligID og sammensæt
        Label mandagMiddag = new Label(getVagter.getVagt(s.getID(), 1));
        Label mandagAften = new Label(getVagter.getVagt(s.getID(), 2));
        Label tirsdagMorgen = new Label(getVagter.getVagt(s.getID(), 3));
        Label tirsdagMiddag = new Label(getVagter.getVagt(s.getID(), 4));
        Label tirsdagAften = new Label(getVagter.getVagt(s.getID(), 5));
        Label onsdagMorgen = new Label(getVagter.getVagt(s.getID(), 6));
        Label onsdagMiddag = new Label(getVagter.getVagt(s.getID(), 7));
        Label onsdagAften = new Label(getVagter.getVagt(s.getID(), 8));
        Label torsdagMorgen = new Label(getVagter.getVagt(s.getID(), 9));
        Label torsdagMiddag = new Label(getVagter.getVagt(s.getID(), 10));
        Label torsdagAften = new Label(getVagter.getVagt(s.getID(), 11));
        Label fredagMorgen = new Label(getVagter.getVagt(s.getID(), 12));
        Label fredagMiddag = new Label(getVagter.getVagt(s.getID(), 13));
        Label fredagAften = new Label(getVagter.getVagt(s.getID(), 14));
        Label lordagMorgen = new Label(getVagter.getVagt(s.getID(), 15));
        Label lordagMiddag = new Label(getVagter.getVagt(s.getID(), 16));
        Label lordagAften = new Label(getVagter.getVagt(s.getID(), 17));
        Label sondagMorgen = new Label(getVagter.getVagt(s.getID(), 18));
        Label sondagMiddag = new Label(getVagter.getVagt(s.getID(), 19));
        Label sondagAften = new Label(getVagter.getVagt(s.getID(), 20));

        //Style from http://www.java2s.com/Tutorials/Java/JavaFX_How_to/HBox/Add_border_style_to_HBox.html
        //First Column, row 1, 2, 3
        HBox clockRow1 = new HBox();
        clockRow1.getChildren().add(eightToTwelve);
        clockRow1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox clockRow2 = new HBox();
        clockRow2.getChildren().add(twelveToFour);
        clockRow2.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox clockRow3 = new HBox();
        clockRow3.getChildren().add(fourToEight);
        clockRow3.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

        //Second Column, row 0, 1, 2, 3
        HBox mondayRow0 = new HBox();
        mondayRow0.getChildren().add(monday);
        mondayRow0.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox mondayRow1 = new HBox();
        mondayRow1.getChildren().add(mandagMorgen);
        mondayRow1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox mondayRow2 = new HBox();
        mondayRow2.getChildren().add(mandagMiddag);
        mondayRow2.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox mondayRow3 = new HBox();
        mondayRow3.getChildren().add(mandagAften);
        mondayRow3.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

        //Third Column, row 0, 1, 2, 3
        HBox tuesdayRow0 = new HBox();
        tuesdayRow0.getChildren().add(tuesday);
        tuesdayRow0.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox tuesdayRow1 = new HBox();
        tuesdayRow1.getChildren().add(tirsdagMorgen);
        tuesdayRow1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox tuesdayRow2 = new HBox();
        tuesdayRow2.getChildren().add(tirsdagMiddag);
        tuesdayRow2.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox tuesdayRow3 = new HBox();
        tuesdayRow3.getChildren().add(tirsdagAften);
        tuesdayRow3.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

        //Fourth Column, row 0, 1, 2, 3
        HBox wednesdayRow0 = new HBox();
        wednesdayRow0.getChildren().add(wednesday);
        wednesdayRow0.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox wednesdayRow1 = new HBox();
        wednesdayRow1.getChildren().add(onsdagMorgen);
        wednesdayRow1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox wednesdayRow2 = new HBox();
        wednesdayRow2.getChildren().add(onsdagMiddag);
        wednesdayRow2.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox wednesdayRow3 = new HBox();
        wednesdayRow3.getChildren().add(onsdagAften);
        wednesdayRow3.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

        //Fifth Column, row 0, 1, 2, 3
        HBox thursdayRow0 = new HBox();
        thursdayRow0.getChildren().add(thursday);
        thursdayRow0.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox thursdayRow1 = new HBox();
        thursdayRow1.getChildren().add(torsdagMorgen);
        thursdayRow1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox thursdayRow2 = new HBox();
        thursdayRow2.getChildren().add(torsdagMiddag);
        thursdayRow2.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox thursdayRow3 = new HBox();
        thursdayRow3.getChildren().add(torsdagAften);
        thursdayRow3.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

        //Sixth Column, row 0, 1, 2, 3
        HBox fridayRow0 = new HBox();
        fridayRow0.getChildren().add(friday);
        fridayRow0.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox fridayRow1 = new HBox();
        fridayRow1.getChildren().add(fredagMorgen);
        fridayRow1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox fridayRow2 = new HBox();
        fridayRow2.getChildren().add(fredagMiddag);
        fridayRow2.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox fridayRow3 = new HBox();
        fridayRow3.getChildren().add(fredagAften);
        fridayRow3.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

        //Seventh Column, row 0, 1, 2, 3
        HBox saturdayRow0 = new HBox();
        saturdayRow0.getChildren().add(saturday);
        saturdayRow0.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox saturdayRow1 = new HBox();
        saturdayRow1.getChildren().add(lordagMorgen);
        saturdayRow1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox saturdayRow2 = new HBox();
        saturdayRow2.getChildren().add(lordagMiddag);
        saturdayRow2.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox saturdayRow3 = new HBox();
        saturdayRow3.getChildren().add(lordagAften);
        saturdayRow3.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

        //Eight Column, row 0, 1, 2, 3
        HBox sundayRow0 = new HBox();
        sundayRow0.getChildren().add(sunday);
        sundayRow0.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox sundayRow1 = new HBox();
        sundayRow1.getChildren().add(sondagMorgen);
        sundayRow1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox sundayRow2 = new HBox();
        sundayRow2.getChildren().add(sondagMiddag);
        sundayRow2.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
        HBox sundayRow3 = new HBox();
        sundayRow3.getChildren().add(sondagAften);
        sundayRow3.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
                + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

        //Add it all into the gridpane
        gridPane.add(clockRow1, 0, 1, 1, 1);
        gridPane.add(clockRow2, 0, 2, 1,1);
        gridPane.add(clockRow3, 0, 3, 1, 1);
        gridPane.add(mondayRow0, 1, 0, 1, 1);
        gridPane.add(mondayRow1, 1, 1, 1, 1);
        gridPane.add(mondayRow2, 1, 2, 1, 1);
        gridPane.add(mondayRow3, 1, 3, 1, 1);
        gridPane.add(tuesdayRow0, 2, 0, 1, 1);
        gridPane.add(tuesdayRow1, 2, 1, 1, 1);
        gridPane.add(tuesdayRow2, 2, 2, 1, 1);
        gridPane.add(tuesdayRow3, 2, 3, 1, 1);
        gridPane.add(wednesdayRow0, 3, 0, 1, 1);
        gridPane.add(wednesdayRow1, 3, 1, 1, 1);
        gridPane.add(wednesdayRow2, 3, 2, 1, 1);
        gridPane.add(wednesdayRow3, 3, 3, 1, 1);
        gridPane.add(thursdayRow0, 4,0,1,1);
        gridPane.add(thursdayRow1, 4, 1, 1, 1);
        gridPane.add(thursdayRow2, 4, 2, 1, 1);
        gridPane.add(thursdayRow3, 4, 3, 1, 1);
        gridPane.add(fridayRow0, 5,0,1,1);
        gridPane.add(fridayRow1, 5, 1, 1, 1);
        gridPane.add(fridayRow2, 5, 2, 1, 1);
        gridPane.add(fridayRow3, 5, 3, 1, 1);
        gridPane.add(saturdayRow0, 6,0,1,1);
        gridPane.add(saturdayRow1, 6, 1, 1, 1);
        gridPane.add(saturdayRow2, 6, 2, 1, 1);
        gridPane.add(saturdayRow3, 6, 3, 1,1);
        gridPane.add(sundayRow0,7,0,1,1);
        gridPane.add(sundayRow1, 7, 1, 1,1 );
        gridPane.add(sundayRow2, 7, 2, 1, 1);
        gridPane.add(sundayRow3, 7, 3, 1, 1);

        first.getChildren().add(gridPane);

        VBox.setVgrow(volunteerScheduleVBox, Priority.ALWAYS);
        volunteerScheduleVBox.getChildren().addAll(top, first);

        getFrivilligHandler.closeFile();
        getVagter.closeFile();

        return volunteerScheduleVBox;
    }

    MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Menu");
        Menu regret = new Menu("Fortryd");
        Menu quickNav = new Menu("Genvej");
        menuBar.getMenus().addAll(quickNav, menu, regret);

        MenuItem menuItemLogScreen = new MenuItem("Login Skærm");
        menuItemLogScreen.setOnAction(e -> main.moveToLogInScreen());
        MenuItem menuItemVSchedule = new MenuItem("Vagtplan Frivillig");
        menuItemVSchedule.setOnAction(e -> main.moveToVolunteerSchedule());
        MenuItem menuItemLOptions = new MenuItem("Ansvarlig Muligheder");
        menuItemLOptions.setOnAction(e -> main.moveToLeaderOptions());
        MenuItem menuItemVList = new MenuItem("Liste over Frivillige");
        menuItemVList.setOnAction(e -> main.moveToVolunteerList());
        MenuItem menuItemVCreate = new MenuItem("Opret Frivillig");
        menuItemVCreate.setOnAction(e -> main.moveToCreateVolunteer());
        MenuItem menuItemSList = new MenuItem("Liste over Boder");
        menuItemSList.setOnAction(e -> main.moveToStallsList());
        MenuItem menuItemSCreate = new MenuItem("Opret Bod");
        menuItemSCreate.setOnAction(e -> main.moveToCreateStall());
        MenuItem menuItemSchedule = new MenuItem("Vagtplan Bod");
        menuItemSchedule.setOnAction(e -> main.moveToStallSchedule());
        MenuItem menuItemCWatch = new MenuItem("Opret Vagt");
        menuItemCWatch.setOnAction(e -> main.moveToCreateStallWatch());
        quickNav.getItems().addAll(menuItemLogScreen, menuItemVSchedule, menuItemLOptions, menuItemVList,
                menuItemVCreate, menuItemSList, menuItemSCreate, menuItemSchedule, menuItemCWatch);

        MenuItem menuItemHelp = new MenuItem("Hjælp");
        menuItemHelp.setOnAction(e -> main.menuHelp());
        MenuItem menuItemBack = new MenuItem("Placeholder");
        MenuItem menuItemClose = new MenuItem("Luk programmet");
        menuItemClose.setOnAction(e -> main.menuClose());
        menu.getItems().addAll(menuItemHelp, menuItemBack, menuItemClose);

        MenuItem menuItemReturn = new MenuItem("Gå tilbage");
        menuItemReturn.setOnAction(e -> main.moveToLogInScreen());
        MenuItem menuItemLogUd = new MenuItem("Log ud");
        menuItemLogUd.setOnAction(e -> main.moveToLogInScreen());
        regret.getItems().addAll(menuItemReturn, menuItemLogUd);

        return menuBar;
    }

    VBox VBoxTop() {
        HBox hBoxTopImg = new HBox(); //HBox to center the Roskilde Logo Image
        hBoxTopImg.setAlignment(Pos.CENTER);
        hBoxTopImg.getChildren().add(RoskildeLogo());

        HBox hBoxMenu = new HBox(); //Horizontal box to try and align the menu to the right instead of left
        //Something does not add up - it appears as a menuButton instead of a menuBar which is what is called
        hBoxMenu.setAlignment(Pos.TOP_RIGHT);
        hBoxMenu.getChildren().add(getMenuBar());

        VBox vBoxTop = new VBox(); //Vertical Box to get both image and menuBar together in the top pane
        vBoxTop.getChildren().addAll(hBoxMenu, hBoxTopImg);
        return vBoxTop;
    }
}