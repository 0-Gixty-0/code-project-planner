package model.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.Window;

public class CreateProjectAction extends AbstractAction{

    @Override
    public void actionPerformed(ActionEvent e) {
        Window.clear_panel();
        System.out.println("perfomed task");
        
    }
}
