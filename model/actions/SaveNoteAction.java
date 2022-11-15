package model.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SaveNoteAction extends AbstractAction{

    private JPanel notePanel;
    private JTextArea textField;
    private JButton button;

    public SaveNoteAction(JPanel notePanelPar) {
        notePanel = notePanelPar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button = (JButton) notePanel.getComponent(1);
        textField = (JTextArea) notePanel.getComponent(3);
        textField.setEditable(false);
        button.setText("Edit Note");
        button.setAction(new EditNoteAction(notePanel));
        
    }
    
}
