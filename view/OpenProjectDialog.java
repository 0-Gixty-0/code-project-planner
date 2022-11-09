package view;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.awt.event.*;

import model.abstractclasses.HasComponents;
import model.actions.*;
import model.filehandling.ProjectsHandling;

public class OpenProjectDialog implements HasComponents, ItemListener {
    private JDialog dialog;
    private JPanel panel;
    private JLabel title;
    private ButtonGroup radioButtonGroup;
    private JButton openButton;
    private JRadioButton radioButton;
    private ArrayList<JRadioButton> radioButtons;
    private String projectToOpen;

    public OpenProjectDialog() {
        dialog = new JDialog(Window.getJFrame(),"Open a Project");
        panel = new JPanel(new GridBagLayout());
        title = new JLabel("To open a project select it in the radio box then press the open button");
        openButton = new JButton();
        radioButtonGroup = new ButtonGroup();
        radioButtons = new ArrayList<JRadioButton>();

        title.setFont(new Font("Arial", Font.PLAIN, 20));

        this.initializeDialog();
    }

    private void initializeDialog() {
        this.positionComponents();
        openButton.setAction(new OpenProjectAction(this));
        openButton.setText("Open Project");
        dialog.add(panel);
        dialog.setSize(1536, 820);
    }

    public void positionComponents() {
        positionLabels();
        positionRadioButtons();
        positionButtons();
    }

    private void positionButtons() {
        GridPositioning.positionComponent(panel, openButton, 0, 3, GridBagConstraints.CENTER, 0.0, 0.0, 2, 1);
    }

    private void positionRadioButtons() {
        ArrayList<String> projectNames = ProjectsHandling.getProjectNames();
        int i;
        int numProjects = ProjectsHandling.getNumProjects();
        if (numProjects == 0) {
            GridPositioning.positionComponent(panel, new JLabel("No projects to open"), 0, 2, GridBagConstraints.CENTER, 0.0, 0.0, 1, 1);
        } else {
            for (i = 0; i < numProjects-1; i++) {
                radioButton = createRadioButton(projectNames, i);
                GridPositioning.positionComponent(panel, radioButton, 0, i+1, GridBagConstraints.CENTER, 0.0, 0.1, 1, 1);
            }
            radioButton = createRadioButton(projectNames, i);
            GridPositioning.positionComponent(panel, radioButton, 0, i+1, GridBagConstraints.CENTER, 0.0, 1.0, 1, 1);
        }
    }

    private JRadioButton createRadioButton(ArrayList<String> projectNames, int i) {
        radioButton = new JRadioButton(projectNames.get(i));
        radioButton.addItemListener(this);
        radioButtons.add(radioButton);
        radioButtonGroup.add(radioButton);
        return radioButton;
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
        for (JRadioButton button : radioButtons) {
            if (button == source) {
                projectToOpen = button.getText();
                System.out.println(projectToOpen);
            }
        }
        
    }

    public String getProjectToOpen() {
        return projectToOpen;
    }
}
