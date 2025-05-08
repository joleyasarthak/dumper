package worksheet.exceptions;

import java.io.IOException;

class ServiceUnavailableException extends Exception {
    public ServiceUnavailableException(String message) {
        super(message);
    }
}

public class Question8 {

    public static void main(String[] args) {
        try {
            readFromFlakyService();
        } catch (ServiceUnavailableException e) {
            System.err.println("Service unavailable: " + e.getMessage());
        }
    }

    static String readFromFlakyService() throws ServiceUnavailableException {
        int attempts = 0;
        while (attempts < 3) {
            try {
                attempts++;
                // Simulate a flaky service
                if (Math.random() > 0.5) {
                    throw new IOException("Service temporarily unavailable");
                }
                return "Data from service"; // Success
            } catch (IOException e) {
                System.err.println("Attempt " + attempts + " failed: " + e.getMessage());
            }
        }
        throw new ServiceUnavailableException("Service unavailable after 3 attempts");
    }
}