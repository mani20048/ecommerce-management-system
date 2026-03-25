package com.ecommerce.service;

import com.ecommerce.dao.OrderDAO;
import com.ecommerce.dao.PaymentDAO;
import com.ecommerce.dao.ProductDAO;
import com.ecommerce.model.Order;
import com.ecommerce.model.Payment;
import com.ecommerce.model.Product;

import java.util.List;

public class OrderService {

    private OrderDAO orderDAO = new OrderDAO();
    private ProductDAO productDAO = new ProductDAO();
    private PaymentDAO paymentDAO = new PaymentDAO();

    // Place order (single product for simplicity)
    public void placeOrder(int userId, int productId, int quantity, String paymentMode) {

        List<Product> products = productDAO.getAllProducts();
        Product selectedProduct = null;

        for (Product p : products) {
            if (p.getId() == productId) {
                selectedProduct = p;
                break;
            }
        }

        if (selectedProduct == null) {
            System.out.println("❌ Product not found");
            return;
        }

        if (selectedProduct.getStock() < quantity) {
            System.out.println("❌ Insufficient stock");
            return;
        }

        double totalAmount = selectedProduct.getPrice() * quantity;

        // Create order
        Order order = new Order();
        order.setUserId(userId);
        order.setTotalAmount(totalAmount);

        int orderId = orderDAO.createOrder(order);

        // Update stock
        int newStock = selectedProduct.getStock() - quantity;
        productDAO.updateStock(productId, newStock);

        // Payment
        Payment payment = new Payment();
        payment.setOrderId(orderId);
        payment.setPaymentMode(paymentMode);
        payment.setStatus("SUCCESS");

        paymentDAO.savePayment(payment);

        System.out.println("✅ Order placed successfully. Order ID: " + orderId);
    }
}
