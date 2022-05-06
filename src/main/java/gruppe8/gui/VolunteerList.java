package gruppe8.gui;

import gruppe8.backend.Frivillig;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static gruppe8.gui.BackgroundPane.*;
import static gruppe8.backend.DataHandlerFrivillig.*;
import static java.util.Arrays.stream;

//List of volunteers
public class VolunteerList extends BorderPane {

    GUI main;
    static String filePath = "src/main/java/gruppe8/Frivillige.txt";

    public VolunteerList(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(volunteerListView());
        setBottom(HBoxBottom());
        setBackground(Background());
    }

    VBox volunteerListView() {
        VBox volunteerList = new VBox();

        HBox topSign = new HBox();
        Text volunteersList = new Text("Liste over Frivillige");
        topSign.setAlignment(Pos.TOP_CENTER);
        volunteersList.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        topSign.getChildren().add(volunteersList);

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        TableView<Frivillig> volunteerTableView = new TableView<>(); //Ændring fra normal til "Generic" udtryk? Warning gav anledning til ny opsætning

        TableColumn<Frivillig, String> firstNameColumn = new TableColumn<>("Fornavn");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        TableColumn<Frivillig, String> lastNameColumn = new TableColumn<>("Efternavn");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        TableColumn<Frivillig, String> ageColumn = new TableColumn<>("Alder");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        TableColumn<Frivillig, String> phoneNumberColumn = new TableColumn<>("Telefon");
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        TableColumn<Frivillig, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        volunteerTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        volunteerTableView.getColumns().addAll(firstNameColumn, lastNameColumn, ageColumn, phoneNumberColumn, emailColumn);

        volunteerTableView.getItems().add(new Frivillig("Constantine", "Undergrove", 42, 42958761, "jubi@dk.dk"));
        volunteerTableView.getItems().add(new Frivillig("Genevieve", "Vandenberg", 35, 8745137, "123@ok.dk"));

        hBox.getChildren().add(volunteerTableView);

        vBox.getChildren().add(hBox);

        VBox button = new VBox();
        button.setAlignment(Pos.BOTTOM_CENTER);
        Button createVolunteer = new Button("Opret en Frivillig");
        createVolunteer.setAlignment(Pos.BOTTOM_CENTER);
        createVolunteer.setOnAction(e -> main.moveToCreateVolunteer());
        button.getChildren().add(createVolunteer);

        volunteerList.setAlignment(Pos.CENTER);
        volunteerList.setSpacing(10);
        volunteerList.getChildren().addAll(topSign,vBox,button);
        return volunteerList;
    }

     /*public class Person {
        private String firstName;
        private String lastName;
        private Integer age;
        private Integer phoneNumber;
        private String email;

        public Person(String firstName, String lastName, Integer age, Integer phoneNumber, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

            public void setFirstName(String name) {this.firstName = name; }
            public String getFirstName() {return this.firstName;}

            public void setLastName(String name){this.firstName = name;}
            public String getLastName() {return this.lastName;}

            public void setAge(int age) {this.age = age;}
            public int getAge(){return this.age;}

            public void setPhoneNumber(int number) {this.phoneNumber = number;}
            public int getPhoneNumber() {return this.phoneNumber;}

            public void setEmail(String email) {this.email = email;}
            public String getEmail() { return this.email;}
    }*/

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