package gruppe8.gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static gruppe8.gui.BackgroundPane.*;


//Ansvarlig Menu
public class LeaderOptions extends BorderPane {

    GUI main;

    public LeaderOptions(GUI main){
        this.main = main;
        setTop(VBoxTop());
        setCenter(leaderGridPane());
        setBottom(HBoxBottom());
    }

    GridPane leaderGridPane() { //Creating the GridPane added in the center of the BorderPane
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 10, 10));

        //For loop to resize columns constantly if window is resized
        //i < 10 because there is 10 columns defined in the grid
        for (int i = 0; i < 10; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setHgrow(Priority.ALWAYS);
            grid.getColumnConstraints().add(cc);
        }

        //For loop to resize rows constantly if window is resized
        //j < 10 because there is 10 rows defined in the grid
        for (int i = 0; i < 10; i++) {
            RowConstraints rc = new RowConstraints();
            rc.setVgrow(Priority.ALWAYS);
            grid.getRowConstraints().add(rc);
        }

        //Headline Top Center
        Text headline = new Text("Ansvarlig på Roskilde");
        headline.setFont(Font.font("Rockwell", FontWeight.BOLD, 30));
        //Note to self; Column Index, Row Index, Column Span, Row Span
        grid.add(headline, 4, 0, 2, 1); //Adding to Column 4 to ensure it stays with Roskilde Logo while resizing
        GridPane.setValignment(headline, VPos.CENTER); //Ensure vertical centering of node
        GridPane.setHalignment(headline, HPos.CENTER); //Ensure horizontal centering of node

        //Button Middle Left
        Button button1 = new Button("Liste over Frivillige");
        grid.add(button1, 3,5); //Button located at headline-1 so it stays put during resizing of window
        GridPane.setValignment(button1, VPos.CENTER);
        GridPane.setHalignment(button1, HPos.LEFT);
        button1.setOnAction(e -> main.moveToVolunteerList());

        //Button Middle Right
        Button button2 = new Button("Liste over Boder");
        grid.add(button2, 6, 5); //Button located at headline+2 since headline spans 2 (Column 4+5)
        //This ensures that the button stays correctly placed, even during resizing of window
        GridPane.setValignment(button2, VPos.CENTER);
        GridPane.setHalignment(button2, HPos.RIGHT);
        button2.setOnAction(e -> main.moveToStallsList());

        return grid;
    }
}
