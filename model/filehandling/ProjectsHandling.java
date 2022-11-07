package model.filehandling;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File; 
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import config.FilePaths;

public class ProjectsHandling {
    private static FileWriter writer;

    public static void updateNumProjects(int numProjects, int modifier) {
        try {
            FileWriter fileOut = new FileWriter(FilePaths.NUMFILESFILEPATH);
            // int numProjects = ProjectsHandling.getNumProjects();
            numProjects += modifier;
            String newNumFiles = Integer.toString(numProjects);
            fileOut.write(newNumFiles);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getNumProjects() {
        int numFiles = 0;
        try {
            File numFilesFile = new File(FilePaths.NUMFILESFILEPATH);
            Scanner reader = new Scanner(numFilesFile);
            numFiles = Integer.valueOf(reader.nextLine());  
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Errror Ocurred");
            e.printStackTrace();
        }
        return numFiles;
    }

    public static void writeProjectName(String projectName) {
        ArrayList<String> contents = ReadFromFile.getFileContents(FilePaths.PROJECTNAMESFILEPATH);
        try {
            File targetFile = new File(FilePaths.PROJECTNAMESFILEPATH);
            writer = new FileWriter(targetFile);
            for (String data : contents) {
                writer.write(data + "\n");
            }
            writer.write(projectName + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An Errror Ocurred");
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getProjectNames() {
        ArrayList<String> projectNames = new ArrayList<String>();
        try {
            File projectNamesFile = new File(FilePaths.PROJECTNAMESFILEPATH);
            Scanner reader = new Scanner(projectNamesFile);
            while (reader.hasNextLine()) {
                projectNames.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Errror Ocurred");
            e.printStackTrace();
        }
        return projectNames;
    }

    public static void removeProjectName(String projectName) {
        ArrayList<String> contents = ProjectsHandling.getProjectNames();
        try {
            File targetFile = new File(FilePaths.PROJECTNAMESFILEPATH);
            writer = new FileWriter(targetFile);
            for (String data : contents) {
                if (!data.equals(projectName)) {
                    writer.write(data + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An Errror Ocurred");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(ProjectsHandling.getProjectNames());
    }
}
