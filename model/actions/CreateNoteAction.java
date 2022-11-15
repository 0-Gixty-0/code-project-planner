package model.actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;

import model.CollectInput;

import view.NewNoteDialog;
import model.filehandling.*;

public class CreateNoteAction extends AbstractAction{
    NewNoteDialog source;
    private ArrayList<String> inputStrings;
    private String noteTitle;
    private String noteDescription;
    private String notePriority;

    public CreateNoteAction(NewNoteDialog sourcePar) {
        source = sourcePar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputStrings = CollectInput.getInputs(source.getTextFields());
        noteTitle = inputStrings.get(0);
        noteDescription = inputStrings.get(1);
        notePriority = inputStrings.get(2);
        ProjectsHandling.updateForNewNote(noteTitle, notePriority, noteDescription);
    }


}
