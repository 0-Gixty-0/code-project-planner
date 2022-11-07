package model.actions;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import config.FilePaths;
import model.filehandling.ProjectsHandling;
import view.DeleteProjectDialog;

public class DeleteProjectAction extends AbstractAction {

    private ArrayList<String> projectsToDelete;
    private String projectPath;
    private DeleteProjectDialog source;

    public DeleteProjectAction(DeleteProjectDialog sourcePar) {
        source = sourcePar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        projectsToDelete = source.getProjectsToDelete();
        for (String projectName : projectsToDelete) {
            projectPath = FilePaths.projectPathsHashMap.get(projectName);
            File file = new File(projectPath);
 
            if (file.delete()) {
                System.out.println("File deleted successfully");
                ProjectsHandling.updateNumProjects(ProjectsHandling.getNumProjects(), -1);
                ProjectsHandling.removeProjectName(projectName);
                ProjectsHandling.removeProjectPath(projectPath);
            }
            else {
                System.out.println("Failed to delete the file");
            }
        }
    }
    
}
