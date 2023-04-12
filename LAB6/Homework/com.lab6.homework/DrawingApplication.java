package com.lab6.homework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class DrawingApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new FXMLLoader(DrawingApplication.class.getResource("mainframe.fxml")).load());
        stage.setScene(scene);
        stage.setTitle("New Drawing Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}