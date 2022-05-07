package gruppe8.gui;

import gruppe8.backend.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

        DataHandlerFrivillig createWatchFrivilligHandler = new DataHandlerFrivillig();
        DataHandlerBod createWatchBodHandler = new DataHandlerBod();

        createWatchBodHandler.openFile();
        createWatchFrivilligHandler.openFile();

        HBox top = new HBox();
        top.setAlignment(Pos.CENTER);

        HBox stallWatchBox = new HBox();
        stallWatchBox.setAlignment(Pos.CENTER_LEFT);

        TableView<Frivillig> volunteerTableView = new TableView<>();
        volunteerTableView.setPrefWidth(150);

        ObservableList<Frivillig> persons = FXCollections.observableArrayList(createWatchFrivilligHandler.dataArray);

        TableColumn<Frivillig, String> firstNameColumn = new TableColumn<>("Fornavn");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Frivillig, String> lastNameColumn = new TableColumn<>("Efternavn");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        volunteerTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        volunteerTableView.setItems(persons);

        createWatchFrivilligHandler.closeFile();

        volunteerTableView.getColumns().addAll(firstNameColumn, lastNameColumn);

        stallWatchBox.getChildren().add(volunteerTableView);



        HBox stallWatchBoxTwo = new HBox();
        stallWatchBoxTwo.setAlignment(Pos.CENTER);

        TableView<Bod> stallsTableView = new TableView<>();
        stallsTableView.setPrefWidth(130);

        ObservableList<Bod> items = FXCollections.observableArrayList(createWatchBodHandler.dataArrayBod);

        TableColumn<Bod, String> stallNameColumn = new TableColumn<>("Bodens Navn");
        stallNameColumn.setCellValueFactory(new PropertyValueFactory<>("navn"));

        stallsTableView.setItems(items);
        stallsTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        stallsTableView.getColumns().add(stallNameColumn);

        createWatchBodHandler.closeFile();

        stallWatchBoxTwo.getChildren().add(stallsTableView);



        HBox stallWatchBoxThree = new HBox();
        stallWatchBoxThree.setAlignment(Pos.CENTER_RIGHT);

        TableView<timeSlot> vagtTableView = new TableView<>();
        vagtTableView.setPrefWidth(130);

        final ObservableList<timeSlot> data = FXCollections.observableArrayList(
                new timeSlot(0, "Mandag 8-12"),
                new timeSlot(1, "Mandag 12-16"),
                new timeSlot(2, "Mandag 16-20"),
                new timeSlot(3, "Tirsdag 8-12"),
                new timeSlot(4, "Tirsdag 12-16"),
                new timeSlot(5, "Tirsdag 16-20"),
                new timeSlot(6, "Onsdag 8-12"),
                new timeSlot(7, "Onsdag 12-16"),
                new timeSlot(8, "Onsdag 16-20"),
                new timeSlot(9, "Torsdag 8-12"),
                new timeSlot(10, "Torsdag 12-16"),
                new timeSlot(11, "Torsdag 16-20"),
                new timeSlot(12, "Fredag 8-12"),
                new timeSlot(13, "Fredag 12-16"),
                new timeSlot(14, "Fredag 16-20"),
                new timeSlot(15, "Lørdag 8-12"),
                new timeSlot(16, "Lørdag 12-16"),
                new timeSlot(17, "Lørdag 16-20"),
                new timeSlot(18, "Søndag 8-12"),
                new timeSlot(19, "Søndag 12-16"),
                new timeSlot(20, "Søndag 16-20")
        );

        TableColumn columnOne = new TableColumn("Tidsrum");
        columnOne.setCellValueFactory(new PropertyValueFactory<timeSlot, String>("timeSlots"));

        vagtTableView.setItems(data);
        vagtTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        vagtTableView.getColumns().addAll(columnOne);

        stallWatchBoxThree.getChildren().add(vagtTableView);

        final String[] temp1 = new String[1];

        stallsTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            temp1[0] = newValue.getNavn();
            createWatchBodHandler.setCurrentBod(temp1[0]);
            System.out.println("Selected Bod: " + temp1[0] + "\n");
        });

        final String[] temp2 = new String[2];

        volunteerTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            temp2[0] = newValue.getFirstName();
            createWatchFrivilligHandler.setTempFirstName(temp2[0]);
            temp2[1] = newValue.getLastName();
            createWatchFrivilligHandler.setTempLastName(temp2[1]);
            System.out.println("Selected Person is: " + temp2[0] + " " + temp2[1] + "\n");
        });

        final Integer[] temp3 = new Integer[1];
        //timeSlot slot = new timeSlot();

        vagtTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            temp3[0] = newValue.getCurrentVagt();
            //createWatchBodHandler.setCurrentVagt(temp3[0]);
            System.out.println("Selected Slot is: " + temp3[0] + "\n");
        });

        top.getChildren().addAll(stallWatchBox, stallWatchBoxTwo, stallWatchBoxThree);

        VBox button = new VBox();
        button.setAlignment(Pos.BOTTOM_CENTER);
        Button confirm = new Button("Bekræft vagt");
        confirm.setOnAction(e -> System.out.println(temp1));
        confirm.setAlignment(Pos.BOTTOM_CENTER);
        button.getChildren().add(confirm);

        createWatch.setAlignment(Pos.CENTER);
        createWatch.setSpacing(30);
        createWatch.getChildren().addAll(hTop, top, button);

        return createWatch;
    }

    public class timeSlot {
        private final SimpleIntegerProperty idSlots;
        private final SimpleStringProperty timeSlotNames;
        public Integer currentVagt;

        private timeSlot(int idSlot, String timeSlotName) {
            this.idSlots = new SimpleIntegerProperty(idSlot);
            this.timeSlotNames = new SimpleStringProperty(timeSlotName);
        }

        public Integer getIdSlots() {
            return idSlots.get();
        }

        public void setIdSlots(int idSlot) {
            idSlots.set(idSlot);
        }

        public String getTimeSlots() {
            return timeSlotNames.get();
        }

        public void setTimeSlotNames(String timeSlotName) {
            timeSlotNames.set(timeSlotName);
        }

        public void setCurrentVagt(Integer a) {
            currentVagt = a;
        }

        public Integer getCurrentVagt() {
            return currentVagt;
        }
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