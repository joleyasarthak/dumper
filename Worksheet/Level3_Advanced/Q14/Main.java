package Level3_Advanced.Q14;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        try {
            Path sourcePath = Paths.get(sourceFile);
            Path destinationPath = Paths.get(destinationFile);

            // Create source file if it doesn't exist
            if (!Files.exists(sourcePath)) {
                Files.createFile(sourcePath);
            }

            byte[] data = Files.readAllBytes(sourcePath);
            Files.write(destinationPath, data);

            System.out.println("Successfully copied data from " + sourceFile + " to " + destinationFile);

        } catch (IOException e) {
            System.err.println("Error reading/writing files: " + e.getMessage());
        }
    }
}