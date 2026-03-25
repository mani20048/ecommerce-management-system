package com.ecommerce.ui;

import com.ecommerce.model.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductUI {

    private User user;

    public ProductUI(User user) {
        this.user = user;
    }

    public void show(Stage stage) {

        Label title = new Label("Admin Dashboard");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button addProductBtn = new Button("Add Product");
        Button viewProductsBtn = new Button("View Products");
        Button reportsBtn = new Button("Generate Reports");
        Button logoutBtn = new Button("Logout");
        Button exitBtn = new Button("Exit");

        addProductBtn.setOnAction(e -> new AddProductUI(user).show(stage));

        viewProductsBtn.setOnAction(e -> new ViewProductsUI(user).show(stage));

        reportsBtn.setOnAction(e -> new ReportsUI(user).show(stage));

        logoutBtn.setOnAction(e -> new LoginUI().show(stage));

        exitBtn.setOnAction(e -> stage.close());

        VBox root = new VBox(
                15,
                title,
                addProductBtn,
                viewProductsBtn,
                reportsBtn,
                logoutBtn,
                exitBtn
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 350, 350));
        stage.setTitle("Admin Dashboard");
        stage.show();
    }
}
