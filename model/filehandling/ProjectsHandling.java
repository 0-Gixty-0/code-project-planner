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

    public static ArrayList<String> getProjectPaths() {
        return ReadFromFile.getFileContents(FilePaths.PROJECTPATHSFILE);
    }

    public static void writeProjectPath(String path) {
        ArrayList<String> contents = ReadFromFile.getFileContents(FilePaths.PROJECTPATHSFILE);
        try {
            File targetFile = new File(FilePaths.PROJECTPATHSFILE);
            writer = new FileWriter(targetFile);
            for (String data : contents) {
                writer.write(data + "\n");
            }
            writer.write(path + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An Errror Ocurred");
            e.printStackTrace();
        }
    }

    public static void removeProjectPath(String projectPath) {
        ArrayList<String> contents = ProjectsHandling.getProjectPaths();
        try {
            File targetFile = new File(FilePaths.PROJECTPATHSFILE);
            writer = new FileWriter(targetFile);
            for (String data : contents) {
                if (!data.equals(projectPath)) {
                    writer.write(data + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An Errror Ocurred");
            e.printStackTrace();
        }
    }

    public static void updateForNewNote(String noteTitle, String notePriority, String noteDescription) {
        ArrayList<String> contents = ReadFromFile.getFileContents(FilePaths.CURRENTOPENFILE);
        Integer numNotes;
        try {
            File targetFile = new File(FilePaths.CURRENTOPENFILE);
            writer = new FileWriter(targetFile);
            for (String data : contents) {
                if (isInt(data)) {
                    numNotes = Integer.parseInt(data);
                    numNotes += 1;
                    writer.write(numNotes + "\n");
                } else {
                    writer.write(data + "\n");
                }
            }
            writer.write(noteTitle + "~" + notePriority + "~" + noteDescription + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An Errror Ocurred");
            e.printStackTrace();
        }
    }

    public static void updateForNoteUpdate(String noteContents, String newNoteContents, String noteTitle, String notePriority) {
        ArrayList<String> contents = ReadFromFile.getFileContents(FilePaths.CURRENTOPENFILE);
        try {
            File targetFile = new File(FilePaths.CURRENTOPENFILE);
            writer = new FileWriter(targetFile);
            for (String data : contents) {
                if (data.equals(noteTitle + "~" + notePriority + "~" + noteContents)) {
                    writer.write(noteTitle + "~" + notePriority + "~" + newNoteContents + "\n");
                } else {
                    writer.write(data + "\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An Errror Ocurred");
            e.printStackTrace();
        }
    }

    private static boolean isInt(String data) {
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException e) {
        } 
        return false;
    }

    public static int getNumNotesFromProject(String projectPath) {
        ArrayList<String> contents = ReadFromFile.getFileContents(projectPath);
        int numNotes = Integer.parseInt(contents.get(1)); 
        return numNotes;
    }

    public static ArrayList<String[]> getNotesContentsFromProject(String projectPath) {
        ArrayList<String> rawContents = ReadFromFile.getFileContents(projectPath);
        ArrayList<String[]> filteredContents = new ArrayList<String[]>();
        String line;
        for (int i = 2; i < rawContents.size(); i++ ) {
            line = rawContents.get(i);
            filteredContents.add(line.split("~"));
        }
        return filteredContents;
    }

    public static String getProjectName(String projectPath) {
        ArrayList<String> contents = ReadFromFile.getFileContents(projectPath);
        return contents.get(0);
    }

    public static void removeNote(String noteContents, String noteTitle, String notePriority) {
        ArrayList<String> contents = ReadFromFile.getFileContents(FilePaths.CURRENTOPENFILE);
        Integer numNotes;
        try {
            File targetFile = new File(FilePaths.CURRENTOPENFILE);
            writer = new FileWriter(targetFile);
            for (String data : contents) {
                if (!data.equals(noteTitle + "~" + notePriority + "~" + noteContents)) {
                    if (isInt(data)) {
                        numNotes = Integer.parseInt(data);
                        numNotes -= 1;
                        writer.write(numNotes + "\n");
                    } else {
                        writer.write(data + "\n");
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An Errror Ocurred");
            e.printStackTrace();
        }
    }
}
