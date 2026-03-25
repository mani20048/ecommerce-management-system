# 🛒 E-Commerce Management System (Java + MySQL + JavaFX)

A complete **E-Commerce Management System** built using **Java**, **MySQL**, and **JavaFX**, designed with clean architecture principles.  
The project supports **both Console (CLI)** and **JavaFX GUI** modes using a shared backend.

---

## 📌 Features

### 👤 Authentication
- User Registration (Admin / Customer)
- User Login with role-based access

### 🛍️ Product Management (Admin)
- Add products
- View products
- Bulk product support (database-level)
- Generate reports

### 📦 Order Management (Customer)
- View available products
- Place orders
- Payment mode selection (CARD / UPI / COD)

### 📊 Reports
- Monthly revenue report (CSV)
- Top-selling products report (CSV)

### 🖥️ Dual Interface Support
- **Console-based (CMD)** application
- **JavaFX GUI** application

---

## 🏗️ Project Architecture

ecommerce-management-system/
│
├── src/
│   └── com/
│       └── ecommerce/
│
│           ├── Main.java # Console (CMD) entry point

            ├── ui/ # JavaFX UI
│           │   ├── MainUI.java
│               ├── LoginUI.java
│               ├── RegisterUI.java
│               ├── ProductUI.java
│               ├── CustomerUI.java
│               ├── AddProductUI.java
│               ├── ViewProductsUI.java
│               ├── PlaceOrderUI.java
│               └── ReportsUI.java
│
│           ├── db/
│           │   └── DBConnection.java
│
│           ├── model/
│           │   ├── User.java
│           │   ├── Product.java
│           │   ├── Order.java
│           │   └── Payment.java
│
│           ├── dao/
│           │   ├── UserDAO.java
│           │   ├── ProductDAO.java
│           │   ├── OrderDAO.java
│           │   └── PaymentDAO.java
│
│           ├── service/
│           │   ├── AuthService.java
│           │   ├── OrderService.java
│           │   └── ReportService.java
│
│           └── util/
│               └── CSVExporter.java
│
├── reports/
│   ├── monthly_revenue.csv
│   └── top_products.csv
│
├── lib/
│   └── mysql-connector-j.jar
│
└── README.md

---

## 🧠 Design Principles Used

- **DAO Pattern**
- **Service Layer Architecture**
- **Separation of Concerns**
- **Reusability (shared backend for CLI & UI)**
- **Prepared Statements (SQL Injection prevention)**

---

## 🗄️ Database Schema

### users

id(INT) With Primary Key
name(VARCHAR)  # User name
email(VARCHAR) # Unique email
password(VARCHAR)  # User password
role(VARCHAR)   # ADMIN/CUSTOMER
created_at(TIMESTAMP) # Account creation time

### products table

id(INT) With Primary Key
name(VARCHAR) # Product name
price(DECIMAL) # Product price
stock(INT)  # Available quantity
created_at(TIMESTAMP)

### orders table

id(INT) With Primary Key
user_id(INT) With Foreign Key # user id
total_amount(DECIMAL)
order_date(TIMESTAMP)

### payments table

id(INT) With Primary Key
order_id(INT) With Foreign Key
payment_mode(VARCHAR)
status(VARCHAR)
payment_date(TIMESTAMP)


## ⚙️ Technologies Used

- Java 21
- JavaFX 21
- MySQL 8
- JDBC
- Java Collections
- CSV File Handling

## ▶️ How to Run (Console Mode)

   ## Go to src folder
   cd D:\ProjectsFolder\ecommerce-management-system\src
## next run below commands
javac -cp ".;../lib/mysql-connector-j.jar" com\ecommerce\Main.java
java -cp ".;../lib/mysql-connector-j.jar" com.ecommerce.Main

## ▶️ How to Run (GUI Mode)
cd D:\ProjectsFolder\ecommerce-management-system\src
# ------------------------------------------------------------------------------------

javac --module-path "C:\Users\manik\Downloads\openjfx-21.0.10-ea+1_windows-x64_bin-sdk\javafx-sdk-21\lib" ^
     --add-modules javafx.controls ^
     -cp ".;../lib/mysql-connector-j.jar" ^
     com\ecommerce\ui\*.java

# ------------------------------------------------------------------------------------

# -------------------------------------------------------------------------------------
java --module-path "C:\Users\manik\Downloads\openjfx-21.0.10-ea+1_windows-x64_bin-sdk\javafx-sdk-21\lib" ^
     --add-modules javafx.controls ^
     -cp ".;../lib/mysql-connector-j.jar" ^
     com.ecommerce.ui.MainUI

# ---------------------------------------------------------------------------------------


## Security Considerations
1.PreparedStatement used to prevent SQL Injection
2.Role-based access control (Admin vs Customer)
3.UI interacts only with Service layer (never DAO)


## Testing
1.Manual testing via Console
2.UI testing via JavaFX
3.Database verification using SQL queries

## Future Enhancements

1.Password hashing (SHA-256 / BCrypt)
2.JDBC transactions
3.Pagination & search in UI
4.Spring Boot REST API
5.Web frontend integration


