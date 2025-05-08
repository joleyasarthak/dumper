package Worksheet.Level1_Basic.Q3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String path = "src/Worksheet/Level1_Basic/Q3/files/";
        File file = new File(path + "report.pdf");
        
        if (file.exists()) {
            System.out.println("File size: " + file.length() + " bytes");
        } else {
            System.out.println("File does not exist");
        }
    }
}