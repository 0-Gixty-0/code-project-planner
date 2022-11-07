package config;

import java.util.ArrayList;
import java.util.HashMap;

public class FilePaths {
    public static String DEFAULTPROJECTDIRECTORY = "C://Users//fired//Documents//GitHub//code-project-planner//projects";
    public static String NUMFILESFILEPATH = "C://Users//fired//Documents//GitHub//code-project-planner//projects//numFiles";
    public static String PROJECTNAMESFILEPATH = "C://Users//fired//Documents//GitHub//code-project-planner//projects//projectNames";
    public static ArrayList<String> projectPaths = new ArrayList<String>();
    public static HashMap<String, String> projectPathsHashMap = new HashMap<String, String>();

    public static void updateProjectPathsHashMap(String key, String path) {
        FilePaths.projectPathsHashMap.put(key, path);
    }
}
