package worksheet.exceptions;

import java.io.IOException;

class CustomException extends Exception {
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Question4 {

    public static void main(String[] args) {
        try {
             RiskyOperation();
        } catch (CustomException e) {
            System.err.println("Caught exception: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Original exception: " + e.getCause().getMessage());
            }
        }
    }

    static void RiskyOperation() throws CustomException {
        try {
            // Simulate an IO exception
            throw new IOException("Simulated IO error");
        } catch (IOException e) {
            throw new CustomException("Error during risky operation", e);
        }
    }
}