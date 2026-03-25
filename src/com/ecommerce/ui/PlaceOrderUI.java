package com.ecommerce.ui;

import com.ecommerce.model.User;
import com.ecommerce.service.OrderService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlaceOrderUI {

    private User user;
    private OrderService orderService = new OrderService();

    public PlaceOrderUI(User user) {
        this.user = user;
    }

    public void show(Stage stage) {

        Label title = new Label("Place Order");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField productIdField = new TextField();
        productIdField.setPromptText("Product ID");

        TextField quantityField = new TextField();
        quantityField.setPromptText("Quantity");

        ComboBox<String> paymentBox = new ComboBox<>();
        paymentBox.getItems().addAll("CARD", "UPI", "COD");
        paymentBox.setPromptText("Payment Mode");

        Button orderBtn = new Button("Place Order");
        Button backBtn = new Button("Back");

        Label message = new Label();

        orderBtn.setOnAction(e -> {
            try {
                int productId = Integer.parseInt(productIdField.getText());
                int quantity = Integer.parseInt(quantityField.getText());
                String paymentMode = paymentBox.getValue();

                if (paymentMode == null) {
                    message.setText("❌ Select payment mode");
                    return;
                }

                orderService.placeOrder(user.getId(), productId, quantity, paymentMode);
                message.setText("✅ Order placed successfully");

            } catch (NumberFormatException ex) {
                message.setText("❌ Product ID and Quantity must be numbers");
            }
        });

        backBtn.setOnAction(e -> new CustomerUI(user).show(stage));

        VBox root = new VBox(
                12,
                title,
                productIdField,
                quantityField,
                paymentBox,
                orderBtn,
                backBtn,
                message
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 400, 350));
        stage.setTitle("Place Order");
        stage.show();
    }
}
