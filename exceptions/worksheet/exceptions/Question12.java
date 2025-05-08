package worksheet.exceptions;

public class Question12 {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.err.println("Global uncaught exception handler: " + exception.getMessage() + " in thread " + thread.getName());
        });

        // Simulate an uncaught exception
        throw new NullPointerException("Simulated uncaught exception");
    }
}