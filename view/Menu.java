package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu {
    public static void main(String[] args) {
    }

    public static JMenuBar initialize_menu_bar() {
        JMenuBar mb = new JMenuBar();
        initialize_menu_tabs(mb);     
        return mb;
    }

    private static void initialize_menu_tabs(JMenuBar mb) {
        JMenu file_menu = new JMenu("File");
        JMenu edit_menu = new JMenu("Edit");
        JMenu view_menu = new JMenu("View");
        JMenu help_menu = new JMenu("Help");
        initialize_menu_items(file_menu);
        mb.add(file_menu);
        mb.add(edit_menu);
        mb.add(view_menu);
        mb.add(help_menu);
    }

    private static void initialize_menu_items(JMenu file_menu) {
        JMenuItem i1, i2, i3, i4, i5;
        i1 = new JMenuItem("New Project");  
        i2 = new JMenuItem("Open Project");  
        i3 = new JMenuItem("New Note");  
        i4 = new JMenuItem("New Flowchart");  
        i5 = new JMenuItem("Save");
        file_menu.add(i1); file_menu.add(i2); file_menu.add(i3); file_menu.add(i4); file_menu.add(i5);
    }



}
