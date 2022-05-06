package gruppe8.gui;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static gruppe8.gui.BackgroundPane.*;

public class CreateStall extends BorderPane {

    GUI main;

    public CreateStall (GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(createStall());
        setBottom(HBoxBottom());
        setBackground(Background());
    }

    VBox createStall() {
        VBox stalls = new VBox();

        HBox top = new HBox();
        Text schedule = new Text("Opret en bod");
        top.setAlignment(Pos.TOP_CENTER);
        schedule.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        top.getChildren().add(schedule);

        VBox vTop = new VBox();

        HBox allFields = new HBox();
        allFields.setAlignment(Pos.TOP_CENTER);
        HBox.setHgrow(allFields, Priority.ALWAYS);
        allFields.setSpacing(20);

        VBox texts = new VBox();
        texts.setAlignment(Pos.CENTER_LEFT);
        texts.setSpacing(18);
        Text stallNameText = new Text("Bodens Navn:");
        stallNameText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        texts.getChildren().add(stallNameText);

        VBox textFields = new VBox();
        textFields.setAlignment(Pos.CENTER_RIGHT);
        textFields.setSpacing(18);
        TextField stallNameTextField = new TextField("Indtast bodens navn");
        textFields.getChildren().add(stallNameTextField);

        allFields.getChildren().addAll(texts, textFields);

        vTop.getChildren().add(allFields);


        VBox button = new VBox();
        button.setAlignment(Pos.BOTTOM_CENTER);
        Button createStallButton = new Button("Opret bod");
        createStallButton.setAlignment(Pos.BOTTOM_CENTER);
        createStallButton.setOnAction(e -> main.moveToStallsList());
        button.getChildren().add(createStallButton);

        stalls.setAlignment(Pos.CENTER);
        stalls.setSpacing(50);
        stalls.getChildren().addAll(top, vTop, button);

        return stalls;
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
        menuItemReturn.setOnAction(e -> main.moveToStallsList());
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
