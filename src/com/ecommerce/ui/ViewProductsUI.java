package com.ecommerce.ui;

import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.service.ProductService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ViewProductsUI {

    private User user;
    private ProductService productService = new ProductService();

    public ViewProductsUI(User user) {
        this.user = user;
    }

    public void show(Stage stage) {

        TableView<Product> tableView = new TableView<>();

        TableColumn<Product, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Product, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> stockCol = new TableColumn<>("Stock");
        stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));

        tableView.getColumns().addAll(idCol, nameCol, priceCol, stockCol);

        List<Product> products = productService.getAllProducts();
        ObservableList<Product> productList = FXCollections.observableArrayList(products);
        tableView.setItems(productList);

        Button backBtn = new Button("Back");

        backBtn.setOnAction(e -> new ProductUI(user).show(stage));

        VBox root = new VBox(10, tableView, backBtn);
        root.setPadding(new Insets(20));

        stage.setScene(new Scene(root, 500, 400));
        stage.setTitle("View Products");
        stage.show();
    }
}
