package config;

import java.util.ArrayList;
import java.util.HashMap;

import model.filehandling.ProjectsHandling;

public class FilePaths {
    public static String DEFAULTPROJECTDIRECTORY = "C://Users//fired//Documents//GitHub//code-project-planner//projects";
    public static String NUMFILESFILEPATH = "C://Users//fired//Documents//GitHub//code-project-planner//projects//numFiles";
    public static String PROJECTNAMESFILEPATH = "C://Users//fired//Documents//GitHub//code-project-planner//projects//projectNames";
    public static String PROJECTPATHSFILE = "C://Users//fired//Documents//GitHub//code-project-planner//config//projectPaths";
    public static ArrayList<String> projectPaths;
    public static HashMap<String, String> projectPathsHashMap;
    public static ArrayList<String> projectNames;

    public static void updateProjectPathsHashMap(String key, String path) {
        FilePaths.projectPathsHashMap.put(key, path);
    }

    public static void initializeProjectPathsHashMap() {
        FilePaths.projectPathsHashMap = new HashMap<String, String>();
        projectNames = ProjectsHandling.getProjectNames();
        projectPaths = ProjectsHandling.getProjectPaths();
        for (int i = 0; i < projectPaths.size(); i++) {
            FilePaths.updateProjectPathsHashMap(projectNames.get(i), projectPaths.get(i));
        }
    }

    public static void initializeConfig() {
        FilePaths.initializeStaticVariables();
    }

    private static void initializeStaticVariables() {
        FilePaths.initializeProjectPathsHashMap();
    }
}
