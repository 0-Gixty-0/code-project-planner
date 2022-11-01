package view;

import java.awt.*;

import javax.swing.*;

import events.editor.*;
import events.listeners.*;

public class Window {
    static JFrame frame;
    static JMenuBar mb;
    static JPanel mainPanel;
    static Editor editor = new Editor();
    public static void main(String[] args) {
    }

    public static void initialize_window() {
        Window.frame = new JFrame("Code Planner");
        Window.mainPanel = new JPanel(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1536,820);
        // frame.setLayout(null);
        mb = Menu.initialize_menu_bar();

    }

    public static void initialize_listeners() {
        editor.events.subscribe("create", new ClickListener());
        editor.events.subscribe("open", new ClickListener());
    }

    public static void render_frame() {
        frame.setVisible(true);
    }

    public static void render_menu() {
        frame.setJMenuBar(mb); 
    }

    public static void welcome_message() {
        // JPanel welcomePanel = new JPanel(new GridBagLayout());
        create_welcome_label(mainPanel, "Welcome to Puls Code Planner:", 1, 0, 0.0, 0.0);
        create_welcome_label(mainPanel, "Use the file tab to create or continue a project", 1, 1, 0.0, 1.0);
        frame.add(mainPanel);

    }

    private static void create_welcome_label(JPanel panel, String string, int gridx, int gridy, double weightx, double weighty) {
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel welcome_label = new JLabel(string);
        GridPositioning.set_grid_x(constraints, gridx);
        GridPositioning.set_grid_y(constraints, gridy);
        GridPositioning.set_weight_x(constraints, weightx);
        GridPositioning.set_weight_y(constraints, weighty);
        GridPositioning.set_anchor(constraints, GridBagConstraints.PAGE_START);
        panel.add(welcome_label, constraints);
    }

        // Stuck here right now -->
    public static void clear_panel() {
        Window.mainPanel.removeAll();
        Window.mainPanel.validate();
    }
}