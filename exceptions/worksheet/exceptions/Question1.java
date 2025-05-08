package worksheet.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class DataProcessingException extends Exception {
    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Question1 {

    private static final Logger LOGGER = Logger.getLogger(Question1.class.getName());

    public static void main(String[] args) {
        try {
            processData();
        } catch (DataProcessingException e) {
            LOGGER.log(Level.SEVERE, "Error processing data: ", e);
        }
    }

    static void processData() throws DataProcessingException {
        try {
            readData();
        } catch (IOException e) {
            throw new DataProcessingException("Failed to process data due to IO error", e);
        }
    }

    static void readData() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line = reader.readLine();
            if (line == null) {
                throw new IOException("End of file reached");
            }
            System.out.println("Read data: " + line);
        }
    }
}