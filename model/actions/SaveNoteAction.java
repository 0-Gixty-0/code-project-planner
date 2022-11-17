package model.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.filehandling.ProjectsHandling;

public class SaveNoteAction extends AbstractAction{

    private JPanel notePanel;
    private JTextArea textField;
    private JButton button;
    private String noteContents;
    private String newNoteContents;
    private String noteTitle;
    private String notePriority;
    private JLabel titleLabel;
    private JLabel priorityLabel;

    public SaveNoteAction(JPanel notePanelPar, String noteContentsPar) {
        notePanel = notePanelPar;
        noteContents = noteContentsPar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        titleLabel = (JLabel) notePanel.getComponent(0);
        noteTitle = titleLabel.getText();
        button = (JButton) notePanel.getComponent(1);
        priorityLabel = (JLabel) notePanel.getComponent(2);
        notePriority = priorityLabel.getText();
        textField = (JTextArea) notePanel.getComponent(3);
        newNoteContents = textField.getText();
        
        textField.setEditable(false);
        button.setAction(new EditNoteAction(notePanel));
        button.setText("Edit Note");

        ProjectsHandling.updateForNoteUpdate(noteContents, newNoteContents, noteTitle, notePriority);
        
    }
    
}
