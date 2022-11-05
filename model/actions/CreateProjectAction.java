package model.actions;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import view.Window;
import view.GridPositioning;
import view.ProjectDialog;
import model.CollectInput;
import model.filehandling.*;

public class CreateProjectAction extends AbstractAction{

    private ArrayList<String> inputStrings;
    private ProjectDialog source;
    private JFrame frame = Window.getJFrame();
    private JPanel panel = Window.getMainPanel();
    private JLabel projectTitleLabel;
    private String path;
    private String projectName;

    public CreateProjectAction(ProjectDialog sourcePar) {
        source = sourcePar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputStrings = CollectInput.getInputs(source.getTextFields());
        projectName = inputStrings.get(0);
        path = inputStrings.get(1);
        createProjectTitle();
        createProjectFile();
    }

    private void createProjectFile() {
        CreateFile.create(path);
        WriteToFile.initializeProjectFile(path, projectName);
    }

    private void createProjectTitle() {
        projectTitleLabel = new JLabel("Project: " + projectName);
        GridPositioning.positionComponent(panel, projectTitleLabel, 0, 0, GridBagConstraints.CENTER, 0.0, 0.0, 1, 1);
        panel.add(projectTitleLabel);
        frame.add(panel);
    }

    // private void awaitInput() {
    //     while (!dialog.isInputRecieved()) {
    //         System.out.println("DISPLAYED_MNEMONIC_INDEX_KEY");
    //     }
    //     inputStrings = dialog.getRecievedInputs();
    // }
}
