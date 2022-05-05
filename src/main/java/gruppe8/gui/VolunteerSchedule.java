package gruppe8.gui;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import static gruppe8.gui.BackgroundPane.HBoxBottom;
import static gruppe8.gui.BackgroundPane.VBoxTop;

public class VolunteerSchedule extends BorderPane {

    GUI main;

    public VolunteerSchedule(GUI main) {
        this.main = main;
        setTop(VBoxTop());
        setCenter(GridSomething());
        setBottom(HBoxBottom());
    }

    GridPane GridSomething() {
        GridPane some = new GridPane();

        return some;
    }
}