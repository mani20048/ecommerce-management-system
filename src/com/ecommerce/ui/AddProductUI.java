package com.ecommerce.ui;

import com.ecommerce.model.User;
import com.ecommerce.service.ProductService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddProductUI {

    private User user;
    private ProductService productService = new ProductService();

    public AddProductUI(User user) {
        this.user = user;
    }

    public void show(Stage stage) {

        Label title = new Label("Add Product");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField nameField = new TextField();
        nameField.setPromptText("Product Name");

        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        TextField stockField = new TextField();
        stockField.setPromptText("Stock");

        Button addBtn = new Button("Add Product");
        Button backBtn = new Button("Back");

        Label messageLabel = new Label();

        addBtn.setOnAction(e -> {
            String name = nameField.getText().trim();
            String priceText = priceField.getText().trim();
            String stockText = stockField.getText().trim();

            if (name.isEmpty() || priceText.isEmpty() || stockText.isEmpty()) {
                messageLabel.setText("❌ All fields are required");
                return;
            }

            try {
                double price = Double.parseDouble(priceText);
                int stock = Integer.parseInt(stockText);

                productService.addProduct(name, price, stock);
                messageLabel.setText("✅ Product added successfully");

                nameField.clear();
                priceField.clear();
                stockField.clear();

            } catch (NumberFormatException ex) {
                messageLabel.setText("❌ Price and Stock must be numbers");
            }
        });

        backBtn.setOnAction(e -> {
            new ProductUI(user).show(stage);
        });

        VBox root = new VBox(
                10,
                title,
                nameField,
                priceField,
                stockField,
                addBtn,
                backBtn,
                messageLabel
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 350, 350));
        stage.setTitle("Add Product");
        stage.show();
    }
}
