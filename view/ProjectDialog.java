package view;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import config.*;
import model.actions.*;
import model.abstractclasses.*;

// import javax.swing.*;

public class ProjectDialog extends CanCollectInput {
    JDialog dialog;
    JPanel panel;
    JLabel title;
    JLabel nameInputLabel;
    JLabel pathInputLabel;
    JTextField nameInputField;
    JTextField pathInputField;
    JButton createButton;
    GridBagConstraints constraints;
    ArrayList<String> recievedInputs;
    boolean inputRecieved = false;

    public ProjectDialog() {
        dialog = new JDialog(Window.getJFrame(),"Create New Project");
        panel = new JPanel(new GridBagLayout());
        title = new JLabel("To create a new project please input the following information:");
        nameInputLabel = new JLabel("Enter a name for your project: ");
        pathInputLabel = new JLabel("Enter a path for your project: ");
        nameInputField = new JTextField(20);
        pathInputField = new JTextField(FilePaths.DEFAULTPROJECTDIRECTORY, 20);
        createButton = new JButton();

        title.setFont( new Font("Arial", Font.PLAIN, 20));

        this.initializeDialog();
    }

    private void initializeDialog() {
        this.positionComponents();
        createButton.setAction(new CreateProjectAction(this));
        createButton.setText("Create Project");
        dialog.add(panel);
        dialog.setSize(1536, 820);
    }

    private void positionComponents() {
        positionLabels();
        positionInputFields();
        positionButtons();
    }

    private void positionButtons() {
        GridPositioning.positionComponent(panel, createButton, 0, 3, GridBagConstraints.CENTER, 0.0, 0.0, 2, 1);
    }

    private void positionInputFields() {
        GridPositioning.positionComponent(panel, nameInputField, 1, 1, GridBagConstraints.FIRST_LINE_START, 0.0, 0.1, 1, 1);
        GridPositioning.positionComponent(panel, pathInputField, 1, 2, GridBagConstraints.FIRST_LINE_START, 0.0, 1.0, 1, 1);
    }

    private void positionLabels() {
        GridPositioning.positionComponent(panel, title, 0, 0, GridBagConstraints.CENTER, 0.0, 0.0, 2, 1);
        GridPositioning.positionComponent(panel, nameInputLabel, 0, 1, GridBagConstraints.FIRST_LINE_END, 0.0, 0.1, 1, 1);
        GridPositioning.positionComponent(panel, pathInputLabel, 0, 2, GridBagConstraints.FIRST_LINE_END, 0.0, 1.0, 1, 1);
    }
    

    public void render(boolean b) {
        dialog.setVisible(b);
    }

    public JDialog getDialog() {
        return dialog;
    }

    @Override
    public JTextField[] getTextFields() {
        return new JTextField[]{nameInputField,pathInputField};
    }

    // public ArrayList<String> getRecievedInputs()  {
    //     return recievedInputs;
    // }

    // public boolean isInputRecieved()  {
    //     return inputRecieved;
    // }

    // @Override
    // public void setRecievedInputs(ArrayList<String> inputStrings) {
    //     recievedInputs = inputStrings;
    //     inputRecieved = true;
    // }
}