package view;

import model.File;
import model.actions.*;
import config.WaMC;

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
        initialize_menu_items(file_menu, WaMC.fileMenuNames, WaMC.fileMenuNames.length);
        initialize_menu_items(edit_menu, WaMC.fileMenuNames, 0);
        initialize_menu_items(view_menu, WaMC.fileMenuNames, 0);
        initialize_menu_items(help_menu, WaMC.fileMenuNames, 0);
        mb.add(file_menu);
        mb.add(edit_menu);
        mb.add(view_menu);
        mb.add(help_menu);
    }

    private static void initialize_menu_items(JMenu menu, String[] strings, int numItems) {
        String menuName = menu.getText();
        switch (menuName) {
            case "File":
                create_menu_items_for_file_menu(menu, strings, numItems);
        }
    }

    private static void create_menu_items_for_file_menu(JMenu menu, String[] strings, int numItems) {
        System.out.println(strings);
        for (String title: strings) {
            JMenuItem x = new JMenuItem();
            switch (title) {
                case "New Project":
                    x.setAction(new CreateProjectCreationDialog());
                    break;

                case "Open Project":
                    x.setAction(new OpenProjectAction());
                    break;

                case "Delete Project":
                    x.setAction(new CreateDeleteProjectDialog());
                    break;
            }
            x.setText(title);
            File.append_menu_item(x);
            menu.add(x);
        }
    }

    // private static void createMenuItemsForEditMenu(JMenu menu, String[] strings, int numItems) {
    //     for (int i = 0; i < numItems; i++) {
    //         JMenuItem x = new JMenuItem();
    //         switch (strings[i]) {
    //             case "New Project":
    //                 x.setAction(new CreateProjectCreationDialog());
    //                 break;

    //             case "Open Project":
    //                 x.setAction(new OpenProjectAction());
    //         }
    //         x.setText(strings[i]);
    //         File.append_menu_item(x);
    //         menu.add(x);
    //     }
    // }
}
