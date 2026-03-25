package com.ecommerce;

import com.ecommerce.model.User;
import com.ecommerce.service.AuthService;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.ReportService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuthService authService = new AuthService();
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        ReportService reportService = new ReportService();

        User loggedInUser = null;

        while (true) {

            System.out.println("\n====== E-COMMERCE MANAGEMENT SYSTEM ======");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Add Product (Admin)");
            System.out.println("4. View Products");
            System.out.println("5. Place Order");
            System.out.println("6. Generate Reports");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Password: ");
                    String password = sc.nextLine();

                    System.out.print("Role (ADMIN/CUSTOMER): ");
                    String role = sc.nextLine();

                    authService.register(name, email, password, role);
                    break;

                case 2:
                    System.out.print("Email: ");
                    String loginEmail = sc.nextLine();

                    System.out.print("Password: ");
                    String loginPassword = sc.nextLine();

                    loggedInUser = authService.login(loginEmail, loginPassword);
                    break;

                case 3:
                    if (loggedInUser == null || !loggedInUser.getRole().equalsIgnoreCase("ADMIN")) {
                        System.out.println("❌ Admin access only");
                        break;
                    }

                    System.out.print("Product Name: ");
                    String productName = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Stock: ");
                    int stock = sc.nextInt();

                    productService.addProduct(productName, price, stock);
                    break;

                case 4:
                    productService.viewAllProductsConsole();
                    break;

                case 5:
                    if (loggedInUser == null) {
                        System.out.println("❌ Please login first");
                        break;
                    }

                    System.out.print("Product ID: ");
                    int productId = sc.nextInt();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Payment Mode (CARD/UPI/COD): ");
                    String paymentMode = sc.nextLine();

                    orderService.placeOrder(
                            loggedInUser.getId(),
                            productId,
                            quantity,
                            paymentMode
                    );
                    break;

                case 6:
                    reportService.generateMonthlyRevenueReport();
                    reportService.generateTopProductsReport();
                    break;

                case 0:
                    System.out.println("👋 Exiting application...");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice");
            }
        }
    }
}
