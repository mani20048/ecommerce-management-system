package com.ecommerce.dao;

import com.ecommerce.db.DBConnection;
import com.ecommerce.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAO {

    // Create order
    public int createOrder(Order order) {
        String sql = "INSERT INTO orders(user_id, total_amount) VALUES (?, ?)";
        int orderId = 0;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, order.getUserId());
            ps.setDouble(2, order.getTotalAmount());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                orderId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderId;
    }
}
