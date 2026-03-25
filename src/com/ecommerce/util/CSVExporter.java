package com.ecommerce.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVExporter {

    public static void export(String filePath, String data) {

        try {
            File file = new File(filePath);

            // Create parent directories if they don't exist
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }

            try (FileWriter writer = new FileWriter(file)) {
                writer.write(data);
            }

            System.out.println("✅ CSV file created: " + filePath);

        } catch (IOException e) {
            System.out.println("❌ Error while writing CSV file");
            e.printStackTrace();
        }
    }
}
