package model;

import java.util.ArrayList;

import javax.swing.JMenuItem;
import java.awt.*;

public class File {
    
    static ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>();
    public static void main(String[] args) {
        
    }

    public static void append_menu_item(JMenuItem item) {
        File.menuItems.add(item);
    }


}
