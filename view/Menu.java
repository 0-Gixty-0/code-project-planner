package view;

import model.File;
import model.actions.CreateProjectAction;
import model.actions.OpenProjectAction;
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
        initialize_menu_items(file_menu, WaMC.fileMenuNames, 5);
        initialize_menu_items(edit_menu, WaMC.fileMenuNames, 0);
        initialize_menu_items(view_menu, WaMC.fileMenuNames, 0);
        initialize_menu_items(help_menu, WaMC.fileMenuNames, 0);
        initialize_menu_items(file_menu, WaMC.fileMenuNames, 0);
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
        for (int i = 0; i < numItems; i++) {
            JMenuItem x = new JMenuItem();
            // System.out.println(i);
            // System.out.println(strings[i]);
            switch (strings[i]) {
                case "New Project":
                    x.setAction(new CreateProjectAction());
                    // System.out.println("ok");
                    break;

                case "Open Project":
                    x.setAction(new OpenProjectAction());
                    // System.out.println("AGGGHHH");
            }
            x.setText(strings[i]);
            File.append_menu_item(x);
            menu.add(x);
            // System.out.println("");
        }
    }
}
