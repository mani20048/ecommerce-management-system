package com.ecommerce.ui;

import com.ecommerce.model.User;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OrderUI {

    private User user;

    public OrderUI(User user) {
        this.user = user;
    }

    public void show(Stage stage) {
        Label label = new Label("Welcome CUSTOMER: " + user.getName());
        VBox root = new VBox(label);
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Customer Dashboard");
    }
}
