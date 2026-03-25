package com.ecommerce.dao;

import com.ecommerce.db.DBConnection;
import com.ecommerce.model.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentDAO {

    // Record payment
    public void savePayment(Payment payment) {
        String sql = "INSERT INTO payments(order_id, payment_mode, status) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, payment.getOrderId());
            ps.setString(2, payment.getPaymentMode());
            ps.setString(3, payment.getStatus());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
