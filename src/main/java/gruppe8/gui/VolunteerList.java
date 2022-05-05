package gruppe8.gui;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import static gruppe8.gui.BackgroundPane.*;

//List of volunteers
public class VolunteerList extends BorderPane {

    GUI main;

    public VolunteerList(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(volunteerListView());
        setBottom(HBoxBottom());
    }

    VBox volunteerListView() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        ListView volunteerList = new ListView();

        volunteerList.getItems().add("Test 1");
        volunteerList.getItems().add("Test 2");
        volunteerList.getItems().add("Test 3");

        hBox.getChildren().add(volunteerList);

        Button opretFrivillig = new Button("Opret en Frivillig");
        opretFrivillig.setAlignment(Pos.BOTTOM_CENTER);
        opretFrivillig.setOnAction(e -> main.moveToCreateVolunteer());

        Button tilbage = new Button("Tilbage Debugger");
        tilbage.setAlignment(Pos.BOTTOM_CENTER);
        tilbage.setOnAction(e -> main.moveToLogInScreen());

        vBox.getChildren().addAll(hBox, opretFrivillig, tilbage);
        return vBox;
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
