package gruppe8.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static gruppe8.gui.BackgroundPane.*;

public class CreateStallWatch extends BorderPane {

    GUI main;

    public CreateStallWatch(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(createStallWatch());
        setBottom(HBoxBottom());
    }

    VBox createStallWatch() {
        VBox createWatch = new VBox();

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
        TextField timeslotField = new TextField("Vælg tidsramme");
        TextField volunteerField = new TextField("Indtast for at søge");
        textFields.getChildren().addAll(timeslotField, volunteerField);

        volunteers.getChildren().addAll(texts, textFields);

        top.getChildren().add(volunteers);

        VBox button = new VBox();
        button.setAlignment(Pos.BOTTOM_CENTER);
        Button confirm = new Button("Bekræft vagt");
        confirm.setOnAction(e -> main.moveToStallSchedule());
        confirm.setAlignment(Pos.BOTTOM_CENTER);
        button.getChildren().add(confirm);

        createWatch.setAlignment(Pos.CENTER);
        createWatch.setSpacing(20);
        createWatch.getChildren().addAll(top, button);

        return createWatch;
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
