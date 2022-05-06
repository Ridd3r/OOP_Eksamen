package gruppe8.gui;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import static gruppe8.gui.BackgroundPane.*;

public class CreateStallWatch extends BorderPane {

    GUI main;

    public CreateStallWatch(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(createStallWatch());
        setBottom(HBoxBottom());
        setBackground(Background());
    }

    VBox createStallWatch() {
        VBox createWatch = new VBox();

        HBox hTop = new HBox();
        Text schedule = new Text("Opret en vagt");
        hTop.setAlignment(Pos.TOP_CENTER);
        schedule.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        hTop.getChildren().add(schedule);

        VBox top = new VBox();

        HBox volunteers = new HBox();
        volunteers.setAlignment(Pos.TOP_CENTER);
        HBox.setHgrow(volunteers, Priority.ALWAYS);

        VBox texts = new VBox();
        texts.setAlignment(Pos.CENTER_LEFT);
        texts.setSpacing(10);
        Text volunteer = new Text("Frivillig: ");
        Text timeslot = new Text("Tidslomme: ");
        texts.getChildren().addAll(volunteer, timeslot);

        VBox textFields = new VBox();
        textFields.setAlignment(Pos.CENTER_RIGHT);
        textFields.setSpacing(10);
        TextField volunteerField = new TextField("Indtast for at søge");
        TextField timeslotField = new TextField("Vælg tidsramme");
        textFields.getChildren().addAll(volunteerField, timeslotField);

        volunteers.getChildren().addAll(texts, textFields);

        top.getChildren().add(volunteers);

        VBox button = new VBox();
        button.setAlignment(Pos.BOTTOM_CENTER);
        Button confirm = new Button("Bekræft vagt");
        confirm.setOnAction(e -> main.moveToStallSchedule());
        confirm.setAlignment(Pos.BOTTOM_CENTER);
        button.getChildren().add(confirm);

        createWatch.setAlignment(Pos.CENTER);
        createWatch.setSpacing(30);
        createWatch.getChildren().addAll(hTop, top, button);

        return createWatch;
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
        menuItemReturn.setOnAction(e -> main.moveToStallSchedule());
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