package model.filehandling;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    private static FileWriter writer;

    public static void initializeProjectFile(String path, String fileName) {
        try {
            writer = new FileWriter(path);
            writer.write(fileName);
            writer.write("0");
            writer.close();
            System.out.println("Initialized new project");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
