package worksheet.exceptions;

import java.io.File;
import java.io.IOException;

class FileValidationException extends Exception {
    public FileValidationException(String message) {
        super(message);
    }
}

class CriticalSystemException extends RuntimeException {
    public CriticalSystemException(String message) {
        super(message);
    }
}

public class Question6 {

    public static void main(String[] args) {
        try {
            validateFile(new File("input.txt"));
        } catch (FileValidationException e) {
            System.err.println("File validation failed: " + e.getMessage());
        }

        try {
            startCriticalService();
        } catch (CriticalSystemException e) {
            System.err.println("Critical service failed to start: " + e.getMessage());
        }
    }

    static void validateFile(File file) throws FileValidationException {
        if (!file.exists()) {
            throw new FileValidationException("File does not exist");
        }
        System.out.println("File validated successfully.");
    }

    static void startCriticalService() {
        // Simulate a critical system failure
        throw new CriticalSystemException("Failed to acquire essential resource");
    }
}