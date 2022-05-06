package gruppe8.gui;

import gruppe8.backend.Bod;
import gruppe8.backend.DataHandlerBod;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static gruppe8.gui.BackgroundPane.*;

public class StallsList extends BorderPane {

    GUI main;

    public StallsList(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(stallsListView());
        setBottom(HBoxBottom());
        setBackground(Background());
    }

    VBox stallsListView() {
        VBox stallsList = new VBox();

        HBox topSign = new HBox();
        Text stallList = new Text("Liste over Boder");
        topSign.setAlignment(Pos.TOP_CENTER);
        stallList.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        topSign.getChildren().add(stallList);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        DataHandlerBod stallsHandler = new DataHandlerBod();
        stallsHandler.openFile();

        TableView<Bod> stallsTableView = new TableView<>();
        stallsTableView.setPrefWidth(400);

        ObservableList<Bod> items = FXCollections.observableArrayList(stallsHandler.dataArray);

        TableColumn<Bod, String> stallNameColumn = new TableColumn<>("Bodens Navn");
        stallNameColumn.setCellValueFactory(new PropertyValueFactory<>("navn"));
        TableColumn<Bod, String> stallAgeRestrictionColumn = new TableColumn<>("Aldersgrænse");
        stallAgeRestrictionColumn.setCellValueFactory(new PropertyValueFactory<>("alderskrav"));
        TableColumn<Bod, String> stallDescriptionColumn = new TableColumn<>("Beskrivelse");
        stallDescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("beskrivelse"));

        stallsTableView.setItems(items);

        stallsTableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

        stallsTableView.getColumns().addAll(stallNameColumn, stallAgeRestrictionColumn, stallDescriptionColumn);

        hBox.getChildren().add(stallsTableView);

        stallsHandler.closeFile();

        vBox.getChildren().add(hBox);

        HBox button = new HBox();
        button.setAlignment(Pos.BOTTOM_CENTER);
        button.setSpacing(30);
        Button createStall = new Button("Opret en Bod");
        createStall.setAlignment(Pos.BOTTOM_LEFT);
        createStall.setOnAction(e -> main.moveToCreateStall());
        Button chooseStall = new Button("Se Vagtplan");
        chooseStall.setAlignment(Pos.BOTTOM_RIGHT);
        chooseStall.setOnAction(e -> main.moveToStallSchedule());
        button.getChildren().addAll(createStall, chooseStall);

        stallsList.setAlignment(Pos.CENTER);
        stallsList.setSpacing(10);
        stallsList.getChildren().addAll(topSign, vBox, button);
        return stallsList;
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
        menuItemReturn.setOnAction(e -> main.moveToLeaderOptions());
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