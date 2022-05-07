package gruppe8.gui;

import gruppe8.backend.DataHandlerFrivillig;
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

//Opret Frivillig
public class CreateVolunteer extends BorderPane {

    GUI main;

    public CreateVolunteer(GUI main){
        this.main = main;
        setTop(VBoxTop());
        setCenter(createVolunteer());
        setBottom(HBoxBottom());
        setBackground(Background());
    }

    VBox createVolunteer() {
        VBox createVolunteerVBox = new VBox();
        DataHandlerFrivillig createVolunteer = new DataHandlerFrivillig();

        HBox hTop = new HBox();
        Text schedule = new Text("Opret en Frivillig");
        hTop.setAlignment(Pos.TOP_CENTER);
        schedule.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        hTop.getChildren().add(schedule);

        VBox top = new VBox();

        HBox allFields = new HBox();
        allFields.setAlignment(Pos.TOP_CENTER);
        HBox.setHgrow(allFields, Priority.ALWAYS);
        allFields.setSpacing(20);

        VBox texts = new VBox();
        texts.setAlignment(Pos.CENTER_LEFT);
        texts.setSpacing(18);
        Text firstNameText = new Text("Fornavn: ");
        firstNameText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Text lastNameText = new Text("Efternavn: ");
        lastNameText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Text ageText = new Text("Alder: ");
        ageText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Text phoneNumberText = new Text("Telefonnummer: ");
        phoneNumberText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        Text emailText = new Text("Email: ");
        emailText.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));
        texts.getChildren().addAll(firstNameText, lastNameText, ageText, phoneNumberText, emailText);

        VBox textFields = new VBox();
        textFields.setAlignment(Pos.CENTER_LEFT);
        textFields.setSpacing(10);
        TextField firstNameTextField = new TextField("Indtast dit fornavn");
        TextField lastNameTextField = new TextField("Indtast dit efternavn");
        TextField ageTextField = new TextField("Indtast din alder");
        TextField phoneNumberTextField = new TextField("Indtast dit telefonnummer");
        TextField emailTextField = new TextField("Indtast din email");
        textFields.getChildren().addAll(firstNameTextField, lastNameTextField, ageTextField, phoneNumberTextField, emailTextField);

        allFields.getChildren().addAll(texts, textFields);

        top.getChildren().add(allFields);

        HBox buttons = new HBox();
        buttons.setSpacing(30);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        Button opret = new Button("Opret Frivillig");
        opret.setOnAction(e -> {createVolunteer.openFile();
            createVolunteer.addFrivillig(firstNameTextField.getText(), lastNameTextField.getText(), Integer.parseInt(ageTextField.getText()),
                    Integer.parseInt(phoneNumberTextField.getText()), emailTextField.getText()); createVolunteer.closeFile();});
        opret.setAlignment(Pos.BOTTOM_LEFT);
        Button goBackButton = new Button("Tilbage til Liste");
        goBackButton.setAlignment(Pos.BOTTOM_RIGHT);
        goBackButton.setOnAction(e -> main.moveToVolunteerList());
        buttons.getChildren().addAll(opret, goBackButton);

        createVolunteerVBox.setAlignment(Pos.CENTER);
        createVolunteerVBox.setSpacing(30);
        createVolunteerVBox.getChildren().addAll(hTop, top, buttons);

        return createVolunteerVBox;
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
        menuItemReturn.setOnAction(e -> main.moveToVolunteerList());
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