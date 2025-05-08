package Worksheet.Level1_Basic.Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "src/Worksheet/Level1_Basic/Q2/files/";
        try {
            File Obj = new File(path + "input.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
            }
            Reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("input.txt Not Found");
            e.printStackTrace();
        }
    }
}
