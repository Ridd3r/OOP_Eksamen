package gruppe8.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;


//Opsætning til Baggrundselementer på tværs af scener
public class BackgroundPane extends BorderPane {

    public static ImageView RoskildeLogo() {
        Image image1 = new Image("file:///C:/Users/JayHo/IdeaProjects/GUIMockUp/src/roskilde3.png");
        ImageView roskildeLogo = new ImageView(image1);
        roskildeLogo.setFitWidth(130);
        roskildeLogo.setFitHeight(90);
        roskildeLogo.setPreserveRatio(true); //Indicates whether to preserve the aspect ratio of the source image when scaling to fit the image within the fitting bounding box.
        roskildeLogo.setSmooth(true); //Should set filtering algorithm from original size picture to a better quality
        roskildeLogo.setCache(true); //Caches the picture to ensure better performance
        return roskildeLogo;
    }

    public static ImageView TuborgLogo() {
        Image image2 = new Image("file:///C:/Users/JayHo/IdeaProjects/GUIMockUp/src/tuborg2.png");
        ImageView tuborgLogo = new ImageView(image2);
        tuborgLogo.setFitWidth(130);
        tuborgLogo.setFitHeight(90);
        tuborgLogo.setPreserveRatio(true);
        tuborgLogo.setSmooth(true);
        tuborgLogo.setCache(true);
        return tuborgLogo;
    }

    public static ImageView LoveSpring() {
        Image image3 = new Image("file:///C:/Users/JayHo/IdeaProjects/GUIMockUp/src/LoveSpringLogo.png");
        ImageView loveSpringLogo = new ImageView(image3);
        loveSpringLogo.setFitWidth(130);
        loveSpringLogo.setFitHeight(90);
        loveSpringLogo.setPreserveRatio(true);
        loveSpringLogo.setSmooth(true);
        loveSpringLogo.setCache(true);
        return loveSpringLogo;
    }

    public static MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();

        Menu menu = new Menu("Menu");
        Menu logUd = new Menu("Log ud");
        menuBar.getMenus().addAll(menu, logUd);

        MenuItem menuItemHelp = new MenuItem("Hjælp");
        MenuItem menuItemBack = new MenuItem("Placeholder");
        MenuItem menuItemClose = new MenuItem("Exit");
        menu.getItems().addAll(menuItemHelp, menuItemBack, menuItemClose);

        return menuBar;
    }

    public static VBox VBoxTop() {
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

    public static HBox HBoxBottom() {
        HBox hBoxLeft = new HBox(); //HBox for Bottom left Logo
        hBoxLeft.setAlignment(Pos.CENTER_LEFT); //Set Position
        HBox.setHgrow(hBoxLeft, Priority.ALWAYS); //Ensure that there the space between this next is always filled
        hBoxLeft.getChildren().add(TuborgLogo());

        HBox hBoxRight = new HBox(); //HBox for Bottom right logo
        hBoxRight.setAlignment(Pos.CENTER_RIGHT); //Set Position
        hBoxRight.getChildren().add(LoveSpring());

        HBox hBox = new HBox(); //Actual Horizontal Box for bottom pane with inherent filler from hBoxLeft
        hBox.getChildren().addAll(hBoxLeft, hBoxRight);
        return hBox;
    }

    public BorderPane addBorderPane() { //Creating the borderpane used in the scene
        BorderPane borderPane = new BorderPane();

        borderPane.setTop(VBoxTop()); //Adding in the top picture and Menu
        borderPane.setLeft(null); //Null, gives a small border to edge of screen for now
        borderPane.setCenter(null); //Adding in the gridpane in the middle
        borderPane.setRight(null); //Null, gives a small border to edge of screen for now
        borderPane.setBottom(HBoxBottom()); //Adding in the logos in the bottom

        borderPane.setBackground(new Background(new BackgroundFill( //Setting background, Source: https://edencoding.com/scene-background/
                new LinearGradient(0, 0, 1, 1, true,
                        CycleMethod.NO_CYCLE,
                        new Stop(0, Color.web("#000000")),
                        new Stop(0.083, Color.web("#2f141a")),
                        new Stop(0.166, Color.web("#5a1e25")),
                        new Stop(0.25, Color.web("#86292a")),
                        new Stop(0.333, Color.web("#b03a28")),
                        new Stop(0.416, Color.web("#c44924")),
                        new Stop(0.5, Color.web("#d65a1b")),
                        new Stop(0.583, Color.web("#e76c0a")),
                        new Stop(0.666, Color.web("#e97905")),
                        new Stop(0.75, Color.web("#eb8502")),
                        new Stop(0.833, Color.web("ed9102")),
                        new Stop(1, Color.web("#ee9d05"))
                ), CornerRadii.EMPTY, Insets.EMPTY
        )));
        return borderPane;
    }

}
