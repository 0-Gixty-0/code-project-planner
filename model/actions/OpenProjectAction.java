package model.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import config.FilePaths;
import view.OpenProjectDialog;
import view.ProjectWindow;

public class OpenProjectAction extends AbstractAction{

    private OpenProjectDialog source;
    private String projectName;

    public OpenProjectAction(OpenProjectDialog sourcePar) {
        source = sourcePar;
    }

    public void actionPerformed(ActionEvent e) {
        projectName = source.getProjectToOpen();
        FilePaths.CURRENTOPENFILE = FilePaths.projectPathsHashMap.get(projectName);
        new ProjectWindow();
    }

    public static void openProject() {
        new ProjectWindow();
    }
}