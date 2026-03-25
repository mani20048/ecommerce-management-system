package com.ecommerce.ui;

import com.ecommerce.model.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerUI {

    private User user;

    public CustomerUI(User user) {
        this.user = user;
    }

    public void show(Stage stage) {

        Label title = new Label("Customer Dashboard");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button viewProductsBtn = new Button("View Products");
        Button placeOrderBtn = new Button("Place Order");
        Button logoutBtn = new Button("Logout");
        Button exitBtn = new Button("Exit");

        viewProductsBtn.setOnAction(e -> new ViewProductsUI(user).show(stage));

        placeOrderBtn.setOnAction(e -> new PlaceOrderUI(user).show(stage));

        logoutBtn.setOnAction(e -> new LoginUI().show(stage));

        exitBtn.setOnAction(e -> stage.close());

        VBox root = new VBox(
                15,
                title,
                viewProductsBtn,
                placeOrderBtn,
                logoutBtn,
                exitBtn
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 350, 300));
        stage.setTitle("Customer Dashboard");
        stage.show();
    }
}
