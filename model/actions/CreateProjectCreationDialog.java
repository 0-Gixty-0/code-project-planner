package model.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.ProjectDialog;
import view.Window;

public class CreateProjectCreationDialog extends AbstractAction {

    private ProjectDialog dialog;

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.clear_panel();
        createDialog();
        }
     
    private void createDialog() {
        dialog = new ProjectDialog();
        dialog.render(true);
    }
    
}
