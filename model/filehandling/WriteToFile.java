package model.filehandling;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    private static FileWriter writer;

    public static void initializeProjectFile(String path, String fileName) {
        try {
            writer = new FileWriter(path);
            writer.write(fileName + "\n");
            writer.write("0\n");
            writer.close();
            System.out.println("Initialized new project");
            ProjectsHandling.updateNumProjects(ProjectsHandling.getNumProjects(), 1);
            ProjectsHandling.writeProjectName(fileName);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
