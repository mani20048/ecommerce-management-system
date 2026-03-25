package com.ecommerce.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainUI extends Application {

    @Override
    public void start(Stage stage) {
        new LoginUI().show(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
