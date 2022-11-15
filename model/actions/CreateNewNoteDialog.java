package model.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.NewNoteDialog;
import view.Window;

public class CreateNewNoteDialog extends AbstractAction {
    private NewNoteDialog dialog;

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.clear_panel();
        createDialog();
    }

    private void createDialog() {
        dialog = new NewNoteDialog();
        dialog.render(true);
    }
    
}
