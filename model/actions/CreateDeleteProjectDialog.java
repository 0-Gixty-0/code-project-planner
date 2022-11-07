package model.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.DeleteProjectDialog;
import view.Window;

public class CreateDeleteProjectDialog extends AbstractAction {
    private DeleteProjectDialog dialog;

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.clear_panel();
        createDialog();
    }

    private void createDialog() {
        dialog = new DeleteProjectDialog();
        dialog.render(true);
    }
    
}
