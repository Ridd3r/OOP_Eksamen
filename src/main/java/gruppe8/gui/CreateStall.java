package gruppe8.gui;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static gruppe8.gui.BackgroundPane.*;

public class CreateStall extends BorderPane {

    GUI main;

    public CreateStall (GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(createStall());
        setBottom(HBoxBottom());
    }

    VBox createStall() {
        VBox stalls = new VBox();
        stalls.setAlignment(Pos.CENTER);
        Label stallName = new Label("Bodens Navn: ", new TextField("Indtast navnet på din bod"));
        stallName.setContentDisplay(ContentDisplay.RIGHT);
        stallName.setAlignment(Pos.CENTER_LEFT);
        stallName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 14));

        HBox button = new HBox(20);
        HBox.setHgrow(button, Priority.ALWAYS);
        button.setAlignment(Pos.BOTTOM_CENTER);
        Button createStallButton = new Button("Opret en bod");
        createStallButton.setAlignment(Pos.BOTTOM_CENTER);
        createStallButton.setOnAction(e -> main.moveToStallsList());
        button.getChildren().add(createStallButton);

        stalls.getChildren().addAll(stallName, button);
        return stalls;
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
