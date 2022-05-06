package gruppe8.gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import static gruppe8.gui.BackgroundPane.*;

//Ansvarlig Menu
public class LeaderOptions extends BorderPane {

    GUI main;

    public LeaderOptions(GUI main){
        this.main = main;
        setTop(VBoxTop());
        setCenter(leaderOptions());
        setBottom(HBoxBottom());
        setBackground(Background());
    }

    VBox leaderOptions() {
        VBox leaderOptionsVBox = new VBox();

        HBox topSign = new HBox();
        Text roskildeLeaderSign = new Text("Ansvarlig på Roskilde");
        topSign.setAlignment(Pos.TOP_CENTER);
        roskildeLeaderSign.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        topSign.getChildren().add(roskildeLeaderSign);

        VBox vBox = new VBox();

        HBox options = new HBox();
        options.setSpacing(20);
        options.setAlignment(Pos.TOP_CENTER);
        HBox.setHgrow(options, Priority.ALWAYS);

        VBox volunteerTexts = new VBox();
        volunteerTexts.setAlignment(Pos.CENTER_LEFT);
        volunteerTexts.setSpacing(20);
        Text volunteerText = new Text("Håndtér Frivillige");
        volunteerText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Button handleVolunteerButton = new Button("Håndtér Frivillige");
        handleVolunteerButton.setOnAction(e -> main.moveToVolunteerList());
        volunteerTexts.getChildren().addAll(volunteerText, handleVolunteerButton);

        VBox stallsTexts = new VBox();
        stallsTexts.setAlignment(Pos.CENTER_RIGHT);
        stallsTexts.setSpacing(20);
        Text stallsText = new Text("Håndtér Boder og Vagtplaner");
        stallsText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Button handleStallsButton = new Button("Håndtér Boder og Vagtplaner");
        handleStallsButton.setOnAction(e -> main.moveToStallsList());
        stallsTexts.getChildren().addAll(stallsText, handleStallsButton);

        options.getChildren().addAll(volunteerTexts, stallsTexts);

        vBox.getChildren().add(options);

        leaderOptionsVBox.setAlignment(Pos.CENTER);
        leaderOptionsVBox.setSpacing(70);
        leaderOptionsVBox.getChildren().addAll(topSign, vBox);
        return leaderOptionsVBox;
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