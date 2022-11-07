package model.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckEmptyFile {
    public static boolean isEmpty(String path) {
        Scanner reader;
        try {
            File targetFile = new File(path);
            reader = new Scanner(targetFile);
            if (reader.hasNextLine()) {
                reader.close();
                return false;
            } else {
                reader.close();
                return true;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
            return true;
        }

    }
}
