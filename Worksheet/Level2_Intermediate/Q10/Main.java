package Worksheet.Level2_Intermediate.Q10;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String folderPath = "Level2_Intermediate/Q10/documents";
        File folder = new File(folderPath);
        
        if (folder.exists() && folder.isDirectory()) {
            System.out.println("Listing contents of " + folderPath + ":");
            File[] files = folder.listFiles();
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}
