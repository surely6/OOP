package assignment2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class clearSpave {
    public static void main(String[] args) {
        // File path to the text file
        String filePath = "src\\TextFile\\SlotInfo - Copy";

        // List to hold the modified rows
        List<String> modifiedRows = new ArrayList<>();

        try {
            // Step 1: Read the file and modify each row
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Replace ", " with ","
                    String modifiedLine = line.replace(", ", ",");
                    // Add the modified line to the list
                    modifiedRows.add(modifiedLine);
                }
            }

            // Step 2: Write the modified rows back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String row : modifiedRows) {
                    writer.write(row);
                    writer.newLine(); // Add a newline after each row
                }
            }

            System.out.println("File updated successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
