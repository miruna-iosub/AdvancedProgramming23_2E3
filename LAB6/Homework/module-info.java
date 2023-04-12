module com.lab6.homework {
        requires javafx.controls;
        requires javafx.fxml;
        requires javafx.web;
        requires javafx.swing;
        requires java.desktop;

        requires org.controlsfx.controls;
        requires com.dlsc.formsfx;
        requires validatorfx;
        requires org.kordamp.ikonli.javafx;
        requires org.kordamp.bootstrapfx.core;
        requires eu.hansolo.tilesfx;
        requires com.google.gson;

        opens com.lab6.homework.files to com.google.gson;
        opens com.lab6.homework to javafx.fxml;
        exports com.lab6.homework;
        }