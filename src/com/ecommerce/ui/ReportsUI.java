package com.ecommerce.ui;

import com.ecommerce.model.User;
import com.ecommerce.service.ReportService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReportsUI {

    private User user;
    private ReportService reportService = new ReportService();

    public ReportsUI(User user) {
        this.user = user;
    }

    public void show(Stage stage) {

        Label title = new Label("Reports");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Button revenueBtn = new Button("Generate Monthly Revenue Report");
        Button productsBtn = new Button("Generate Top Products Report");
        Button backBtn = new Button("Back");

        Label message = new Label();

        revenueBtn.setOnAction(e -> {
            reportService.generateMonthlyRevenueReport();
            message.setText("✅ Monthly revenue report generated");
        });

        productsBtn.setOnAction(e -> {
            reportService.generateTopProductsReport();
            message.setText("✅ Top products report generated");
        });

        backBtn.setOnAction(e -> new ProductUI(user).show(stage));

        VBox root = new VBox(12, title, revenueBtn, productsBtn, backBtn, message);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 400, 300));
        stage.setTitle("Reports");
        stage.show();
    }
}
