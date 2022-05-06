module gruppe8.gruppe8_eksamensaflevering {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens gruppe8.gui to javafx.fxml;
    exports gruppe8.gui;
    opens gruppe8.backend to javafx.fxml;
    exports gruppe8.backend;
}