package com.ecommerce.service;

import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Product;

import java.util.List;

public class ProductService {

    private ProductDAO productDAO = new ProductDAO();

    // Add product (used by Admin UI)
    public void addProduct(String name, double price, int stock) {

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);

        productDAO.addProduct(product);
    }

    // Return all products (USED BY UI)
    public List<Product> getAllProducts() {
        return productDAO.getAllProducts();
    }

    // OPTIONAL: console testing (can be removed later)
    public void viewAllProductsConsole() {

        List<Product> products = productDAO.getAllProducts();

        System.out.println("\n--- PRODUCT LIST ---");
        for (Product p : products) {
            System.out.println(
                    p.getId() + " | " +
                    p.getName() + " | ₹" +
                    p.getPrice() + " | Stock: " +
                    p.getStock()
            );
        }
    }
}
