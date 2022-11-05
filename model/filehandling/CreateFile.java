package model.filehandling;
import java.io.File;
import java.io.IOException;

import config.FilePaths;

public class CreateFile {
    public static void create(String path) {
        try {
            File projectFile = new File(path);
            if (projectFile.createNewFile()) {
                System.out.println("File created");
                FilePaths.projectPaths.add(path);
            } else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }

    }
}
