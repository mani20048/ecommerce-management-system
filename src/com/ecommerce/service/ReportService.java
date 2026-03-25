package com.ecommerce.service;

import com.ecommerce.util.CSVExporter;

public class ReportService {

    // Monthly revenue report (dummy data for now)
    public void generateMonthlyRevenueReport() {

        String data = "Month,Revenue\n" +
                      "January,45000\n" +
                      "February,38000\n" +
                      "March,52000\n";

        CSVExporter.export("reports/monthly_revenue.csv", data);
        System.out.println("✅ Monthly revenue report generated");
    }

    // Top products report (dummy data for now)
    public void generateTopProductsReport() {

        String data = "Product,Sales\n" +
                      "Laptop,120\n" +
                      "Mobile,95\n" +
                      "Headphones,80\n";

        CSVExporter.export("reports/top_products.csv", data);
        System.out.println("✅ Top products report generated");
    }
}
