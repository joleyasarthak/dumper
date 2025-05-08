package worksheet.exceptions;

class CustomResource1 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("Exception from CustomResource1 close()");
    }
}

class CustomResource2 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("Exception from CustomResource2 close()");
    }
}

public class Question7 {

    public static void main(String[] args) {
        try (CustomResource1 res1 = new CustomResource1();
             CustomResource2 res2 = new CustomResource2()) {
            // Use resources
            System.out.println("Using resources...");
        } catch (Exception e) {
            System.err.println("Main exception: " + e.getMessage());
            Throwable[] suppressed = e.getSuppressed();
            if (suppressed != null) {
                for (Throwable t : suppressed) {
                    System.err.println("Suppressed exception: " + t.getMessage());
                }
            }
        }
    }
}