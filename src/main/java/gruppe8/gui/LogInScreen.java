package gruppe8.gui;

import javafx.geometry.Pos;
import javafx.scene.control.*;
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

    MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Menu");
        menuBar.getMenus().add(menu);

        MenuItem menuItemHelp = new MenuItem("Hjælp");
        menuItemHelp.setOnAction(e -> main.menuHelp());
        MenuItem menuItemBack = new MenuItem("Placeholder");
        MenuItem menuItemLogUd = new MenuItem("Log ud");
        menuItemLogUd.setOnAction(e -> main.moveToLogInScreen());
        MenuItem menuItemClose = new MenuItem("Luk programmet");
        menuItemClose.setOnAction(e -> main.menuClose());
        menu.getItems().addAll(menuItemHelp, menuItemBack, menuItemLogUd, menuItemClose);

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
