package view;

import java.awt.*;

import javax.swing.*;

public class Window {
    JFrame frame;
    JMenuBar mb;
    public static void main(String[] args) {
    }

    public void initialize_window() {
        frame = new JFrame("Code Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1536,820);
        // frame.setLayout(null);
        mb = Menu.initialize_menu_bar();

    }

    public void render_frame() {
        frame.setVisible(true);
    }

    public void render_menu() {
        frame.setJMenuBar(mb); 
    }

    public void welcome_message() {
        JPanel welcomePanel = new JPanel(new GridBagLayout());
        create_welcome_label(welcomePanel, "Welcome to Puls Code Planner:", 1, 0, 0.0, 0.0);
        create_welcome_label(welcomePanel, "Use the file tab to create or continue a project", 1, 1, 0.0, 1.0);
        frame.add(welcomePanel);

    }

    private void create_welcome_label(JPanel welcomePanel, String string, int gridx, int gridy, double weightx, double weighty) {
        GridBagConstraints constraints = new GridBagConstraints();
        JLabel welcome_label = new JLabel(string);
        GridPositioning.set_grid_x(constraints, gridx);
        GridPositioning.set_grid_y(constraints, gridy);
        GridPositioning.set_weight_x(constraints, weightx);
        GridPositioning.set_weight_y(constraints, weighty);
        GridPositioning.set_anchor(constraints, GridBagConstraints.PAGE_START);
        welcomePanel.add(welcome_label, constraints);
    }
}