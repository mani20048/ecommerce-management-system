package com.ecommerce.service;

import com.ecommerce.dao.UserDAO;
import com.ecommerce.model.User;

public class AuthService {

    private UserDAO userDAO = new UserDAO();

    public void register(String name, String email, String password, String role) {

        User existingUser = userDAO.getUserByEmail(email);
        if (existingUser != null) {
            System.out.println("❌ User already exists");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        userDAO.saveUser(user);
        System.out.println("✅ User registered successfully");
    }

    public User login(String email, String password) {

        User user = userDAO.getUserByEmail(email);

        if (user == null) {
            System.out.println("❌ User not found");
            return null;
        }

        if (!user.getPassword().equals(password)) {
            System.out.println("❌ Invalid password");
            return null;
        }

        System.out.println("✅ Login successful");
        return user;
    }
}
