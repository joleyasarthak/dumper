package Level3_Advanced.Q12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) {
        String folderPath = "."; // Current directory
        String outputFile = "merged.txt";

        try {
            List<Path> textFiles = Files.list(Paths.get(folderPath))
                    .filter(file -> file.toString().endsWith(".txt"))
                    .collect(Collectors.toList());

            try (FileWriter writer = new FileWriter(outputFile)) {
                for (Path file : textFiles) {
                    List<String> lines = Files.readAllLines(file);
                    for (String line : lines) {
                        writer.write(line + System.lineSeparator());
                    }
                }
            }

            System.out.println("Successfully merged text files into " + outputFile);

        } catch (IOException e) {
            System.err.println("Error merging files: " + e.getMessage());
        }
    }
}
