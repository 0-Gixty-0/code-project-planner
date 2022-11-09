package model.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.OpenProjectDialog;
import view.Window;

public class CreateOpenProjectDialog extends AbstractAction{

    private OpenProjectDialog dialog;

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.clear_panel();
        createDialog();
        
    }

    private void createDialog() {
        dialog = new OpenProjectDialog();
        dialog.render(true);
    }
    
}
