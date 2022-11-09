package model.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.OpenProjectDialog;

public class OpenProjectAction extends AbstractAction{

    private OpenProjectDialog source;

    public OpenProjectAction(OpenProjectDialog sourcePar) {
        source = sourcePar;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        
    }
}