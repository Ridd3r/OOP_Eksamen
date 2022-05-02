package gruppe8.gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class GUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Creating the scene
        //addGridPane giver første side, addGridPane2 giver anden side
        //Der er ikke bygget event handlers til at få knappen til at gå videre til næste side endnu
        Scene scene = new Scene(addGridPane()); //Create the scene
        primaryStage.setTitle("Graphical User Interface Mockup"); //Stage Title
        primaryStage.setScene(scene); //Placing scene in stage
        primaryStage.show(); //Display stage
    }

    public GridPane addGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setStyle("-fx-background-color: #ded2d2;");


        //Test Sizes
        /*ColumnConstraints cc = new ColumnConstraints(100, 100, Double.MAX_VALUE,
                Priority.ALWAYS, HPos.CENTER, true);
        grid.getColumnConstraints().addAll(cc, cc);

        RowConstraints rc = new RowConstraints(20, 20, Double.MAX_VALUE,
                Priority.ALWAYS, VPos.CENTER, true);
        grid.getRowConstraints().addAll(rc, rc);
        */
        //grid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //grid.setPadding(new Insets(0, 10, 0, 10));

        //Top Left
        Image image1 = new Image("file:///C:/Users/JayHo/IdeaProjects/GUIMockUp/src/roskilde3.png");
        ImageView roskildeLogo = new ImageView(image1);
        roskildeLogo.setFitWidth(130);
        roskildeLogo.setFitHeight(90);
        roskildeLogo.setPreserveRatio(true); //Indicates whether to preserve the aspect ratio of the source image when scaling to fit the image within the fitting bounding box.
        roskildeLogo.setSmooth(true); //Should set filtering algorithm from original size picture to a better quality
        roskildeLogo.setCache(true); //Caches the picture to ensure better performance
        GridPane.setValignment(roskildeLogo, VPos.TOP);
        GridPane.setHalignment(roskildeLogo, HPos.LEFT);
        grid.add(roskildeLogo, 0,0,1,1);

        //Bottom Left
        Image image2 = new Image("file:///C:/Users/JayHo/IdeaProjects/GUIMockUp/src/tuborg2.png");
        ImageView sponsor1 = new ImageView(image2);
        sponsor1.setFitWidth(130);
        sponsor1.setFitHeight(90);
        sponsor1.setPreserveRatio(true);
        sponsor1.setSmooth(true);
        sponsor1.setCache(true);
        GridPane.setValignment(sponsor1, VPos.BOTTOM);
        GridPane.setHalignment(sponsor1, HPos.LEFT);
        grid.add(sponsor1, 0,10,1,1);

        //Bottom Right
        Image image3 = new Image("file:///C:/Users/JayHo/IdeaProjects/GUIMockUp/src/LoveSpringLogo.png");
        ImageView sponsor2 = new ImageView(image3);
        sponsor2.setFitWidth(130);
        sponsor2.setFitHeight(90);
        sponsor2.setPreserveRatio(true);
        sponsor2.setSmooth(true);
        sponsor2.setCache(true);
        GridPane.setValignment(sponsor2, VPos.BOTTOM);
        GridPane.setHalignment(sponsor2, HPos.RIGHT);
        grid.add(sponsor2, 9,9, 2,2);

        //Headline Top Center
        Text headline = new Text("Frivillig på Roskilde");
        headline.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        //Note to self; Column Index, Row Index, Column Span, Row Span
        grid.add(headline, 3, 1, 2, 1);

        //Button Middle Left
        Button button1 = new Button("Opret Frivillig");
        grid.add(button1, 3,5);

        //Button Middle Right
        Button button2 = new Button("Frivillig Liste");
        grid.add(button2, 5, 5);

        //Button Top Right
        Button button3 = new Button("Menu");
        GridPane.setValignment(button3, VPos.TOP);
        GridPane.setHalignment(button3, HPos.RIGHT);
        grid.add(button3, 10,0);

        //Button Top Right 2
        Button button4 = new Button("Sprog: Dansk");
        GridPane.setValignment(button4, VPos.TOP);
        GridPane.setHalignment(button4, HPos.RIGHT);
        grid.add(button4, 9, 0);

        return grid;
    }

    public GridPane addGridPane2() {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setStyle("-fx-background-color: #ded2d2;");

        //Test Sizes
        /*ColumnConstraints cc = new ColumnConstraints(100, 100, Double.MAX_VALUE,
                Priority.ALWAYS, HPos.CENTER, true);
        grid.getColumnConstraints().addAll(cc, cc);

        RowConstraints rc = new RowConstraints(20, 20, Double.MAX_VALUE,
                Priority.ALWAYS, VPos.CENTER, true);
        grid.getRowConstraints().addAll(rc, rc);
        */
        //grid.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        //grid.setPadding(new Insets(0, 10, 0, 10));

        //Top Left
        Image image1 = new Image("file:///C:/Users/JayHo/IdeaProjects/GUIMockUp/src/roskilde3.png");
        ImageView roskildeLogo = new ImageView(image1);
        roskildeLogo.setFitWidth(130);
        roskildeLogo.setFitHeight(90);
        roskildeLogo.setPreserveRatio(true); //Indicates whether to preserve the aspect ratio of the source image when scaling to fit the image within the fitting bounding box.
        roskildeLogo.setSmooth(true); //Should set filtering algorithm from original size picture to a better quality
        roskildeLogo.setCache(true); //Caches the picture to ensure better performance
        GridPane.setValignment(roskildeLogo, VPos.TOP);
        GridPane.setHalignment(roskildeLogo, HPos.LEFT);
        grid.add(roskildeLogo, 0,0,1,1);

        //Bottom Left
        Image image2 = new Image("file:///C:/Users/JayHo/IdeaProjects/GUIMockUp/src/tuborg2.png");
        ImageView sponsor1 = new ImageView(image2);
        sponsor1.setFitWidth(130);
        sponsor1.setFitHeight(90);
        sponsor1.setPreserveRatio(true);
        sponsor1.setSmooth(true);
        sponsor1.setCache(true);
        GridPane.setValignment(sponsor1, VPos.BOTTOM);
        GridPane.setHalignment(sponsor1, HPos.LEFT);
        grid.add(sponsor1, 0,10,1,1);

        //Bottom Right
        Image image3 = new Image("file:///C:/Users/JayHo/IdeaProjects/GUIMockUp/src/LoveSpringLogo.png");
        ImageView sponsor2 = new ImageView(image3);
        sponsor2.setFitWidth(130);
        sponsor2.setFitHeight(90);
        sponsor2.setPreserveRatio(true);
        sponsor2.setSmooth(true);
        sponsor2.setCache(true);
        GridPane.setValignment(sponsor2, VPos.BOTTOM);
        GridPane.setHalignment(sponsor2, HPos.RIGHT);
        grid.add(sponsor2, 9,9, 2,2);

        //Headline Top Center
        Text headline = new Text("Opret en Frivillig");
        headline.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        //Note to self; Column Index, Row Index, Column Span, Row Span
        grid.add(headline, 2, 1, 5, 2);

        //Opret Frivllig Textboxes Name, Age, Adress, Nationality, Email,
        Text name = new Text("Navn");
        TextField textfield = new TextField();
        grid.add(name, 3,4);
        grid.add(textfield, 4, 4);

        Text age = new Text("Alder");
        TextField textfield2 = new TextField();
        grid.add(age, 3,5);
        grid.add(textfield2, 4, 5);

        Text address = new Text("Addresse");
        TextField textfield3 = new TextField();
        grid.add(address, 3,6);
        grid.add(textfield3, 4, 6);

        Text nationality = new Text("Nationalitet");
        TextField textfield4 = new TextField();
        grid.add(nationality, 3,7);
        grid.add(textfield4, 4, 7);

        Text email = new Text("Email");
        TextField textfield5 = new TextField();
        grid.add(email, 3,8);
        grid.add(textfield5, 4, 8);

        //Button Top Right
        Button button3 = new Button("Menu");
        GridPane.setValignment(button3, VPos.TOP);
        GridPane.setHalignment(button3, HPos.RIGHT);
        grid.add(button3, 10,0);

        //Button Top Right 2
        Button button4 = new Button("Sprog: Dansk");
        GridPane.setValignment(button4, VPos.TOP);
        GridPane.setHalignment(button4, HPos.RIGHT);
        grid.add(button4, 9, 0);

        return grid;
    }
}