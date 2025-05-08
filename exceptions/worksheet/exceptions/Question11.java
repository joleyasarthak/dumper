package worksheet.exceptions;

public class Question11 {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.err.println("Uncaught exception in thread " + thread.getName() + ": " + exception.getMessage());
        });

        Thread childThread = new Thread(() -> {
            throw new RuntimeException("Exception from child thread");
        });

        childThread.start();
    }
}