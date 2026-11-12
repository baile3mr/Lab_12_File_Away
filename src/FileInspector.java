import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;

        // Set JFileChooser to open in the src directory of the IntelliJ project
        File workingDirectory = new File(System.getProperty("user.dir") + "/src");
        if (workingDirectory.exists()) {
            chooser.setCurrentDirectory(workingDirectory);
        }

        System.out.println("Please choose a text file to inspect...");

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            Path file = selectedFile.toPath();

            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            System.out.println("\n--- Echoing File Contents ---");

            // Read the file line by line using standard NIO and try-catch
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    lineCount++;
                    System.out.println("Line " + lineCount + ": " + line);

                    // Count characters in the line
                    charCount += line.length();

                    // Count words using split on whitespace (handle empty lines safely)
                    if (!line.trim().isEmpty()) {
                        String[] words = line.trim().split("\\s+");
                        wordCount += words.length;
                    }
                }

                // Print the required summary report
                System.out.println("\n==============================");
                System.out.println("      FILE SUMMARY REPORT     ");
                System.out.println("==============================");
                System.out.println("File Name:        " + selectedFile.getName());
                System.out.println("Number of Lines:  " + lineCount);
                System.out.println("Number of Words:  " + wordCount);
                System.out.println("Number of Chars:  " + charCount);
                System.out.println("==============================");

            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
                e.printStackTrace();
            }

        } else {
            System.out.println("No file selected. Program terminating.");
        }
    }
}