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
        System.out.println("Action commenced");
        projectsToDelete = source.getProjectsToDelete();
        System.out.println(projectsToDelete.size());
        for (String projectName : projectsToDelete) {
            System.out.println(projectName);
            projectPath = FilePaths.projectPathsHashMap.get(projectName);
            File file = new File(projectPath);
 
            if (file.delete()) {
                System.out.println("File deleted successfully");
                ProjectsHandling.updateNumProjects(ProjectsHandling.getNumProjects(), -1);
                ProjectsHandling.removeProjectName(projectName);
            }
            else {
                System.out.println("Failed to delete the file");
            }
        }
    }
    
}
