package com.ecommerce.ui;

import com.ecommerce.service.AuthService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterUI {

    private AuthService authService = new AuthService();

    public void show(Stage stage) {

        Label title = new Label("User Registration");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        TextField nameField = new TextField();
        nameField.setPromptText("Full Name");

        TextField emailField = new TextField();
        emailField.setPromptText("Email Address");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Confirm Password");

        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("ADMIN", "CUSTOMER");
        roleBox.setPromptText("Select Role");

        Button registerBtn = new Button("Register");
        Button backBtn = new Button("Back to Login");

        Label messageLabel = new Label();

        registerBtn.setOnAction(e -> {

            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String password = passwordField.getText();
            String confirmPassword = confirmPasswordField.getText();
            String role = roleBox.getValue();

            // Validation
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()
                    || confirmPassword.isEmpty() || role == null) {
                messageLabel.setText("❌ All fields are required");
                return;
            }

            if (!password.equals(confirmPassword)) {
                messageLabel.setText("❌ Passwords do not match");
                return;
            }

            if (!email.contains("@")) {
                messageLabel.setText("❌ Invalid email format");
                return;
            }

            // Call backend
            authService.register(name, email, password, role);
            messageLabel.setText("✅ Registration successful");

            // Optional: clear fields
            nameField.clear();
            emailField.clear();
            passwordField.clear();
            confirmPasswordField.clear();
            roleBox.setValue(null);
        });

        backBtn.setOnAction(e -> new LoginUI().show(stage));

        VBox root = new VBox(
                10,
                title,
                nameField,
                emailField,
                passwordField,
                confirmPasswordField,
                roleBox,
                registerBtn,
                backBtn,
                messageLabel
        );

        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 350, 420);
        stage.setScene(scene);
        stage.setTitle("Register");
        stage.show();
    }
}
