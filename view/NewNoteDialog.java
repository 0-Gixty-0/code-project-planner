package view;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import model.actions.*;

import model.abstractclasses.CanCollectInput;

public class NewNoteDialog extends CanCollectInput{
    JDialog dialog;
    JPanel panel;
    JLabel title;
    JLabel nameInputLabel;
    JLabel priorityInputLabel;
    JLabel descriptionInputLabel;
    JTextField nameInputField;
    JTextField priorityInputField;
    JTextField descriptionInputField;
    JButton createButton;
    GridBagConstraints constraints;
    ArrayList<String> recievedInputs;
    boolean inputRecieved = false;

    public NewNoteDialog() {
        dialog = new JDialog(Window.getJFrame(),"Create A New Note");
        panel = new JPanel(new GridBagLayout());
        title = new JLabel("To create a new note please input the following information:");
        nameInputLabel = new JLabel("Enter a title for your note: ");
        descriptionInputLabel = new JLabel("Enter a description for your note: ");
        priorityInputLabel = new JLabel("Enter a priority for your note (1-5)");
        nameInputField = new JTextField(20);
        descriptionInputField = new JTextField(40);
        priorityInputField = new JTextField(20);
        createButton = new JButton();

        title.setFont( new Font("Arial", Font.PLAIN, 20));

        this.initializeDialog();
    }

    private void initializeDialog() {
        this.positionComponents();
        createButton.setAction(new CreateNoteAction(this));
        createButton.setText("Create Note");
        dialog.add(panel);
        dialog.setSize(1536, 820);
    }

    protected void positionComponents() {
        positionLabels();
        positionInputFields();
        positionButtons();
    }

    private void positionButtons() {
        GridPositioning.positionComponent(panel, createButton, 0, 4, GridBagConstraints.CENTER, 0.0, 0.0, 2, 1);
    }

    private void positionInputFields() {
        GridPositioning.positionComponent(panel, nameInputField, 1, 1, GridBagConstraints.FIRST_LINE_START, 0.0, 0.1, 1, 1);
        GridPositioning.positionComponent(panel, descriptionInputField, 1, 2, GridBagConstraints.FIRST_LINE_START, 0.0, 0.1, 1, 1);
        GridPositioning.positionComponent(panel, priorityInputField, 1, 3, GridBagConstraints.FIRST_LINE_START, 0.0, 1.0, 1, 1);
    }

    private void positionLabels() {
        GridPositioning.positionComponent(panel, title, 0, 0, GridBagConstraints.CENTER, 0.0, 0.0, 2, 1);
        GridPositioning.positionComponent(panel, nameInputLabel, 0, 1, GridBagConstraints.FIRST_LINE_END, 0.0, 0.1, 1, 1);
        GridPositioning.positionComponent(panel, descriptionInputLabel, 0, 2, GridBagConstraints.FIRST_LINE_END, 0.0, 0.1, 1, 1);
        GridPositioning.positionComponent(panel, priorityInputLabel, 0, 3, GridBagConstraints.FIRST_LINE_END, 0.0, 1.0, 1, 1);
    }
    

    public void render(boolean b) {
        dialog.setVisible(b);
    }

    public JDialog getDialog() {
        return dialog;
    }

    @Override
    public JTextField[] getTextFields() {
        return new JTextField[]{nameInputField,descriptionInputField,priorityInputField};
    }
    
}
