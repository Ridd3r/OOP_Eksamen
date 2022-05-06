package gruppe8.gui;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static gruppe8.gui.BackgroundPane.*;

//Primær Login Side
public class LogInScreen extends BorderPane {

    GUI main;

    public LogInScreen(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(logInScreen());
        setBottom(HBoxBottom());
        setBackground(Background());
    }

    VBox logInScreen() {
        VBox logInScreenVBox = new VBox();

        HBox topSign = new HBox();
        Text logInSign = new Text("Velkommen til Roskilde Festival!");
        topSign.setAlignment(Pos.TOP_CENTER);
        logInSign.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        topSign.getChildren().add(logInSign);

        VBox vBox = new VBox();

        HBox loginDetails = new HBox();
        loginDetails.setAlignment(Pos.TOP_CENTER);
        HBox.setHgrow(loginDetails, Priority.ALWAYS);

        VBox texts = new VBox();
        texts.setAlignment(Pos.CENTER_LEFT);
        texts.setSpacing(10);
        Text usernameText = new Text("Brugernavn: ");
        Text passwordText = new Text("Adgangskode: ");
        texts.getChildren().addAll(usernameText, passwordText);

        VBox textFields = new VBox();
        textFields.setAlignment(Pos.CENTER_RIGHT);
        textFields.setSpacing(10);
        TextField usernameTextField = new TextField("Indtast brugernavn");
        TextField passwordTextField = new TextField("Indtast adgangskode");
        textFields.getChildren().addAll(usernameTextField, passwordTextField);

        loginDetails.getChildren().addAll(texts, textFields);

        vBox.getChildren().add(loginDetails);

        HBox button = new HBox();
        button.setAlignment(Pos.BOTTOM_CENTER);
        button.setSpacing(30);
        Button loginVolunteer = new Button("Frivillig");
        loginVolunteer.setAlignment(Pos.BOTTOM_LEFT);
        loginVolunteer.setOnAction(e -> main.moveToVolunteerSchedule());
        Button loginLeader = new Button("Ansvarlig");
        loginLeader.setAlignment(Pos.BOTTOM_RIGHT);
        loginLeader.setOnAction(e -> main.moveToLeaderOptions());
        button.getChildren().addAll(loginVolunteer, loginLeader);

        logInScreenVBox.setAlignment(Pos.CENTER);
        logInScreenVBox.setSpacing(50);
        logInScreenVBox.getChildren().addAll(topSign, vBox, button);
        return logInScreenVBox;
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