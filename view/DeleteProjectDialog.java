package view;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

import model.abstractclasses.HasComponents;
import model.actions.*;
import model.filehandling.ProjectsHandling;

public class DeleteProjectDialog implements HasComponents, ItemListener {
    private JDialog dialog;
    private JPanel panel;
    private JLabel title;
    private JCheckBox selectionCheckBox;
    private JButton deleteButton;
    private ArrayList<JCheckBox> checkBoxes;
    private ArrayList<String> projectsToDelete;

    public DeleteProjectDialog() {
        dialog = new JDialog(Window.getJFrame(),"Delete a project");
        panel = new JPanel(new GridBagLayout());
        title = new JLabel("To delete a project select it in the check box then press the delete button");
        deleteButton = new JButton();
        projectsToDelete = new ArrayList<String>();
        checkBoxes = new ArrayList<JCheckBox>();

        title.setFont(new Font("Arial", Font.PLAIN, 20));

        this.initializeDialog();
    }

    private void initializeDialog() {
        this.positionComponents();
        deleteButton.setAction(new DeleteProjectAction(this));
        deleteButton.setText("Delete Project(s)");
        dialog.add(panel);
        dialog.setSize(1536, 820);
    }

    public void positionComponents() {
        positionLabels();
        positionCheckBoxes();
        positionButtons();
    }

    private void positionButtons() {
        GridPositioning.positionComponent(panel, deleteButton, 0, 3, GridBagConstraints.CENTER, 0.0, 0.0, 2, 1);
    }

    private void positionCheckBoxes() {
        ArrayList<String> projectNames = ProjectsHandling.getProjectNames();
        int i;
        int numProjects = ProjectsHandling.getNumProjects();
        if (numProjects == 0) {
            GridPositioning.positionComponent(panel, new JLabel("No projects to delete"), 0, 2, GridBagConstraints.CENTER, 0.0, 0.0, 1, 1);
        } else {
            for (i = 0; i < ProjectsHandling.getNumProjects()-1; i++) {
                selectionCheckBox = new JCheckBox(projectNames.get(i));
                selectionCheckBox.addItemListener(this);
                GridPositioning.positionComponent(panel, selectionCheckBox, 0, i+1, GridBagConstraints.CENTER, 0.0, 0.1, 1, 1);
                checkBoxes.add(selectionCheckBox);
            }
            selectionCheckBox = new JCheckBox(projectNames.get(i));
            selectionCheckBox.addItemListener(this);
            checkBoxes.add(selectionCheckBox);
            GridPositioning.positionComponent(panel, selectionCheckBox, 0, i+1, GridBagConstraints.CENTER, 0.0, 1.0, 1, 1);
        }
    }

    private void positionLabels() {
        GridPositioning.positionComponent(panel, title, 0, 0, GridBagConstraints.CENTER, 0.0, 0.0, 2, 1);
    }
    

    public void render(boolean b) {
        dialog.setVisible(b);
    }

    public JDialog getDialog() {
        return dialog;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        for (JCheckBox box : checkBoxes) {
            if (box == source) {
                projectsToDelete.add(box.getText());
            }
        }
        
    }

    public ArrayList<String> getProjectsToDelete() {
        return projectsToDelete;
    }
}
