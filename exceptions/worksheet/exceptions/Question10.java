package worksheet.exceptions;

public class Question10 {

    public static void main(String[] args) {
        // Misusing exceptions for control flow (bad practice)
        int[] array = {1, 2, 3, 4, 5};
        try {
            for (int i = 0; ; i++) {
                if (array[i] == 3) {
                    throw new IndexOutOfBoundsException("Found 3");
                }
                System.out.println(array[i]);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Stopped because: " + e.getMessage());
        }

        // Refactored code (good practice)
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 3) {
                System.out.println("Found 3, stopping");
                break;
            }
            System.out.println(array[i]);
        }
    }
}