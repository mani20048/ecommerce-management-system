package com.ecommerce.ui;

import com.ecommerce.model.User;
import com.ecommerce.service.AuthService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginUI {

    private AuthService authService = new AuthService();

    public void show(Stage stage) {

        Label title = new Label("Login");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginBtn = new Button("Login");
        Button registerBtn = new Button("Register");
        Button exitBtn = new Button("Exit");

        Label messageLabel = new Label();

        loginBtn.setOnAction(e -> {
            String email = emailField.getText().trim();
            String password = passwordField.getText();

            if (email.isEmpty() || password.isEmpty()) {
                messageLabel.setText("❌ All fields are required");
                return;
            }

            User user = authService.login(email, password);

            if (user != null) {
                messageLabel.setText(""); // clear error message

                // Role-based navigation
                if (user.getRole().equalsIgnoreCase("ADMIN")) {
                    new ProductUI(user).show(stage);
                } else {
                    new CustomerUI(user).show(stage);
                }
            } else {
                messageLabel.setText("❌ Invalid credentials");
            }
        });

        registerBtn.setOnAction(e -> {
            new RegisterUI().show(stage);
        });

        exitBtn.setOnAction(e -> {
            stage.close();
        });

        VBox root = new VBox(
                10,
                title,
                emailField,
                passwordField,
                loginBtn,
                registerBtn,
                exitBtn,
                messageLabel
        );

        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 320, 320));
        stage.setTitle("Login");
        stage.show();
    }
}
