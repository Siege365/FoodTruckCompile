module com.example.softwareproj {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires javafx.media;
    requires io;
    requires javafx.swing;
    requires kernel;
    requires layout;

    opens com.example.softwareproj to javafx.fxml;
    exports com.example.softwareproj;
    exports com.example.softwareproj.AdminRelated;
    opens com.example.softwareproj.AdminRelated to javafx.fxml;
    exports com.example.softwareproj.CustomerSideRelated;
    opens com.example.softwareproj.CustomerSideRelated to javafx.fxml;
    exports com.example.softwareproj.DatabaseRelated;
    opens com.example.softwareproj.DatabaseRelated to javafx.fxml;
}