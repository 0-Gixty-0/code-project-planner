package model.filehandling;

import java.util.ArrayList;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
    public static ArrayList<String> getFileContents(String path) {
        ArrayList<String> contents = new ArrayList<String>();
        if (!CheckEmptyFile.isEmpty(path)) {
            try {
                File targetFile = new File(path);
                Scanner reader = new Scanner(targetFile);
                // reader.nextLine();
                while (reader.hasNextLine()) {
                    contents.add(reader.nextLine());
                }
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An Errror Ocurred");
                e.printStackTrace();
            }
        }
        return contents;
    }
}
