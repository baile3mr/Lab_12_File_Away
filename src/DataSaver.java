import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        ArrayList<String> records = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean continueInput = true;

        System.out.println("=== Data Saver Program ===");

        // Loop to collect records
        while (continueInput) {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter first name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter last name");

            // Ensures ID is strictly 6 digits (e.g., 000001)
            String idNumber = SafeInput.getRegExString(in, "Enter ID number (6 digits, e.g., 000001)", "^\\d{6}$");

            String email = SafeInput.getNonZeroLenString(in, "Enter email address");

            // Gets a valid 4-digit birth year within a realistic range
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter year of birth", 1900, 2026);

            // Construct the CSV record string
            String csvRecord = firstName + ", " + lastName + ", " + idNumber + ", " + email + ", " + yearOfBirth;
            records.add(csvRecord);

            // Ask if the user wants to add another record
            continueInput = SafeInput.getYNConfirm(in, "Would you like to add another record?");
        }

        // Prompt for the output filename
        String fileName = SafeInput.getNonZeroLenString(in, "Enter the filename to save (e.g., userdata)");
        if (!fileName.endsWith(".csv")) {
            fileName += ".csv";
        }

        // Define the target path in the src directory
        File workingDirectory = new File(System.getProperty("user.dir") + "/src");
        File file = new File(workingDirectory, fileName);

        // Write the ArrayList records to the CSV file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String record : records) {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("\nData successfully saved to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}