package view;

import java.awt.Component;

import javax.swing.*;

public class Window {
    JFrame frame;
    JMenuBar mb;
    public static void main(String[] args) {
    }

    public void initialize_window() {
        frame = new JFrame("Code Planner");
        System.out.println(frame.getComponents());
        frame.setSize(1536,820);
        frame.setLayout(null);
        mb = Menu.initialize_menu_bar();

    }

    public void render_frame() {
        frame.setVisible(true);
    }

    public void render_menu() {
        frame.setJMenuBar(mb); 
    }

    public void welcome_message() {
        JPanel welcomePanel = new JPanel();
        String welcome_1 = "Welcome to Puls Code Planner:";
        String welcome_2 = "Use the file tab to create or continue a project";
        JLabel welcome_label_1 = new JLabel();
        JLabel welcome_label_2 = new JLabel();
        welcome_label_1.setText(welcome_1);
        welcome_label_2.setText(welcome_2);
        welcome_label_1.setVerticalTextPosition(JLabel.CENTER);
        welcome_label_2.setHorizontalTextPosition(JLabel.CENTER);
        welcomePanel.add(welcome_label_1);
        welcomePanel.add(welcome_label_2);
        frame.getContentPane().add(welcomePanel);
        // frame.add(welcome_label_1);
        // frame.add(welcome_label_2);
        Component[] components = frame.getComponents();
        for (Component component : components) {
            System.out.println(component);
        }

    }
}