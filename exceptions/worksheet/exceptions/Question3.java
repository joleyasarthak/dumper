package worksheet.exceptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Question3 {

    public static void main(String[] args) {
        try {
            copyFile("input.txt", "output.txt");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    static void copyFile(String source, String destination) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}