package model.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.*;
import javax.swing.JPanel;

import model.filehandling.ProjectsHandling;
import view.Window;

public class DeleteNoteAction extends AbstractAction{
    private JPanel notePanel;
    private JFrame frame;
    private JTextArea textField;
    private String noteContents;
    private String noteTitle;
    private String notePriority;
    private JLabel titleLabel;
    private JLabel priorityLabel;

    public DeleteNoteAction(JPanel notePanelPar) {
        notePanel = notePanelPar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame = Window.getJFrame();
        titleLabel = (JLabel) notePanel.getComponent(0);
        noteTitle = titleLabel.getText();
        priorityLabel = (JLabel) notePanel.getComponent(2);
        notePriority = priorityLabel.getText();
        textField = (JTextArea) notePanel.getComponent(3);
        noteContents = textField.getText();
        ProjectsHandling.removeNote(noteContents, noteTitle, notePriority);
        notePanel.removeAll();
        frame.remove(notePanel);
        Window.revalidateFrame();
    }
    
}
